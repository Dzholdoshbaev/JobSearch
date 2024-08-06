package dzholdoshbaev.jobsearch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final DataSource dataSource;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        String fetchUsers = """
                select email , password ,enabled
                from users
                where email = ?;
                """;

        String fetchAuthorities = """
                select email , authority
                from users u, authorities a
                where u.authority_id = a.id
                and email = ?;
                """;

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(fetchUsers)
                .authoritiesByUsernameQuery(fetchAuthorities);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.POST,"/resumes/create").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.PUT,"/resumes/edit").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.DELETE,"/resumes/delete/").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.POST,"/applicants/responded").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"/applicants").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/applicants/resume/").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"/applicants/vacancy/").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.GET,"/users").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/users/email/").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/users/phone/").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/users/check/").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/vacancies/create").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.PUT,"/vacancies/edit").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.DELETE,"/vacancies/delete/").hasAuthority("EMPLOYER")
                        .anyRequest().permitAll());
        return http.build();
    }

}
