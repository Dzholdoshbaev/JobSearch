package dzholdoshbaev.jobsearch.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .formLogin(form -> form
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/auth/login")
                        .successHandler(new CustomAuthenticationSuccessHandler())
                        .failureUrl("/auth/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/auth/logout")
                        .logoutSuccessUrl("/auth/login")
                        .permitAll())
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.POST,"/resumes/create").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.PUT,"/resumes/edit").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.DELETE,"/resumes/delete/").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.POST,"/applicants/responded").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"/applicants/resume/").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"/applicants/vacancy/").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.POST,"/vacancies/create").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.PUT,"/vacancies/edit").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.DELETE,"/vacancies/delete/").hasAuthority("EMPLOYER")
                        .anyRequest().permitAll());
        return http.build();
    }




}
