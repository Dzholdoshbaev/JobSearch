package dzholdoshbaev.jobsearch.config;

import dzholdoshbaev.jobsearch.service.UsersService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;

@Configuration
public class LocaleConfig implements WebMvcConfigurer {

    private final UsersService usersService;

    public LocaleConfig(UsersService usersService) {
        this.usersService = usersService;
    }

    @Bean
    public CustomLocaleChangeInterceptor localeChangeInterceptor() {
        return new CustomLocaleChangeInterceptor(usersService);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
