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
                        .requestMatchers(HttpMethod.POST,"/images").authenticated()
                        .requestMatchers(HttpMethod.GET,"/profile").authenticated()
                        .requestMatchers(HttpMethod.GET,"/profile/edit").authenticated()
                        .requestMatchers(HttpMethod.GET,"/profile/company/").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"/resumes/create").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.POST,"/resumes/create").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"/resumes/update/{resumeId}").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"resumes/edit/{resumeId}").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.POST,"resumes/edit/{resumeId}").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"resumes").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.GET,"resumes/{resumeId}").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.GET,"/vacancies").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"/vacancies/{vacancyId}").hasAuthority("APPLICANT")
                        .requestMatchers(HttpMethod.GET,"/vacancies/create").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.POST,"/vacancies/create").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.GET,"/vacancies/update/{vacancyId}").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.GET,"/vacancies/edit/{vacancyId}").hasAuthority("EMPLOYER")
                        .requestMatchers(HttpMethod.POST,"/vacancies/edit/{vacancyId}").hasAuthority("EMPLOYER")
                        .anyRequest().permitAll());
        return http.build();
    }




}
