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
                        .requestMatchers(HttpMethod.POST,"/resumes/create").hasRole("APPLICANT")
                        .requestMatchers(HttpMethod.PUT,"/resumes/edit").hasRole("APPLICANT")
                        .requestMatchers(HttpMethod.DELETE,"/resumes/delete/").hasRole("APPLICANT")
                        .requestMatchers(HttpMethod.POST,"/applicants/responded").hasRole("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"/applicants").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/applicants/resume/").hasRole("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"/applicants/vacancy/").hasRole("EMPLOYER")
                        .requestMatchers(HttpMethod.GET,"/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/users/email/").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/users/phone/").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/users/check/").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/vacancies/create").hasRole("EMPLOYER")
                        .requestMatchers(HttpMethod.PUT,"/vacancies/edit").hasRole("EMPLOYER")
                        .requestMatchers(HttpMethod.DELETE,"/vacancies/delete/").hasRole("EMPLOYER")
                        .anyRequest().permitAll());
        return http.build();
    }

}
