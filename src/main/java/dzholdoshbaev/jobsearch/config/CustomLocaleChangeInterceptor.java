package dzholdoshbaev.jobsearch.config;

import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.security.Principal;
import java.util.Locale;

public class CustomLocaleChangeInterceptor extends LocaleChangeInterceptor {
    private final UsersService usersService;

    public CustomLocaleChangeInterceptor(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Principal principal = request.getUserPrincipal();
        String newLocale = request.getParameter("lang");

        if (principal != null) {
            String email = principal.getName();
            Users users = usersService.getUserByEmail(email);

            if (users != null && users.getLocale() != null) {
                Locale locale = new Locale(users.getLocale());
                RequestContextUtils.getLocaleResolver(request).setLocale(request, response, locale);
            }

            if (newLocale != null && !newLocale.equals(users.getLocale())) {
                usersService.updateUserLocale(email, newLocale);
                Locale locale = new Locale(newLocale);
                RequestContextUtils.getLocaleResolver(request).setLocale(request, response, locale);
            }
        }

        return true;
    }

}
