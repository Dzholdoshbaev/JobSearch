package dzholdoshbaev.jobsearch.config;

import dzholdoshbaev.jobsearch.constant.Authority;
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
                        .requestMatchers(HttpMethod.POST,"/images").authenticated()
                        .requestMatchers(HttpMethod.GET,"/profile").authenticated()
                        .requestMatchers(HttpMethod.GET,"/profile/edit").authenticated()
                        .requestMatchers(HttpMethod.GET,"/profile/company/*").hasAuthority(Authority.APPLICANT.getAuthority())
                        .requestMatchers(HttpMethod.GET,"/resumes/create").hasAuthority(Authority.APPLICANT.getAuthority())
                        .requestMatchers(HttpMethod.POST,"/resumes/create").hasAuthority(Authority.APPLICANT.getAuthority())
                        .requestMatchers(HttpMethod.GET,"/resumes/update/*").hasAuthority(Authority.APPLICANT.getAuthority())
                        .requestMatchers(HttpMethod.GET,"resumes/edit/*").hasAuthority(Authority.APPLICANT.getAuthority())
                        .requestMatchers(HttpMethod.POST,"resumes/edit/*").hasAuthority(Authority.APPLICANT.getAuthority())
                        .requestMatchers(HttpMethod.GET,"/vacancies").hasAuthority(Authority.APPLICANT.getAuthority())
                        .requestMatchers(HttpMethod.GET,"/vacancies/*").hasAuthority(Authority.APPLICANT.getAuthority())
                        .requestMatchers(HttpMethod.GET,"resumes").hasAuthority(Authority.EMPLOYER.getAuthority())
                        .requestMatchers(HttpMethod.GET,"resumes/*").hasAuthority(Authority.EMPLOYER.getAuthority())
                        .requestMatchers(HttpMethod.GET,"/vacancies/create").hasAuthority(Authority.EMPLOYER.getAuthority())
                        .requestMatchers(HttpMethod.POST,"/vacancies/create").hasAuthority(Authority.EMPLOYER.getAuthority())
                        .requestMatchers(HttpMethod.GET,"/vacancies/update/*").hasAuthority(Authority.EMPLOYER.getAuthority())
                        .requestMatchers(HttpMethod.GET,"/vacancies/edit/*").hasAuthority(Authority.EMPLOYER.getAuthority())
                        .requestMatchers(HttpMethod.POST,"/vacancies/edit/*").hasAuthority(Authority.EMPLOYER.getAuthority())
                        .anyRequest().permitAll());
        return http.build();
    }




}
