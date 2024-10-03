package dzholdoshbaev.jobsearch.controller;

import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/reset")
@RequiredArgsConstructor
public class PasswordRecoveryController {
    private final UsersService usersService;

    @GetMapping
    public String resetPassword() {
        return "passwordRecovery/forgot_form";
    }

    @PostMapping
    public String forgotPassword(@RequestParam String email, Model model, Locale locale) {
        if (email == null || email.isEmpty()) {
            String message = locale.getLanguage().equals("en")
                    ? "You have to write an email"
                    : "Вы должны написать почтовый адрес";
            model.addAttribute("errorMessage", message);
            return "passwordRecovery/forgot_form";
        }

        if (!usersService.checkUserByEmail(email)) {
            String message = locale.getLanguage().equals("en")
                    ? "We don't have a user with this email, sorry"
                    : "Такой пользователь не найден";
            model.addAttribute("errorMessage", message);
            return "passwordRecovery/forgot_form";
        }

        usersService.addTokenToUser(email);
        Users user = usersService.getUserByEmail(email);
        return "redirect:/reset/token/" + user.getId();
    }

    @GetMapping("/token/{userId}")
    public String token(@PathVariable Long userId, Model model) {
        Users user = usersService.getUserById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        if (user.getResetPasswordToken() == null) {
            throw new NoSuchElementException("Reset password token not found");
        }
        model.addAttribute("resetPasswordToken", user.getResetPasswordToken());
        model.addAttribute("user", user);
        return "passwordRecovery/check_token";
    }

    @PostMapping("/token/{userId}")
    public String checkToken(@PathVariable Long userId, @RequestParam String token, Model model, Locale locale) {
        if (token == null || token.isEmpty()) {
            String message = locale.getLanguage().equals("en")
                    ? "Token is required"
                    : "Токен обязателен";
            model.addAttribute("errorMessage", message);
            return "passwordRecovery/check_token";
        }

        Users user = usersService.getUserById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));

        Users tokenUser = usersService.userWithToken(token);
        if (tokenUser == null) {
            String message = locale.getLanguage().equals("en")
                    ? "Invalid token"
                    : "Неверный токен";
            model.addAttribute("errorMessage", message);
            model.addAttribute("resetPasswordToken", user.getResetPasswordToken());
            model.addAttribute("user", user);
            return "passwordRecovery/check_token";
        }

        return "redirect:/reset/password/" + user.getId();
    }

    @GetMapping("/password/{userId}")
    public String password(@PathVariable Long userId, Model model) {
        Users user = usersService.getUserById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        if (user.getResetPasswordToken() == null) {
            throw new NoSuchElementException("Reset password token not found");
        }

        model.addAttribute("userId", userId);
        return "passwordRecovery/change_password";
    }

    @PostMapping("/password/{userId}")
    public String changePassword(@RequestParam String password, @PathVariable Long userId, Model model, Locale locale) {
        Users user = usersService.getUserById(userId).orElseThrow(() -> new NoSuchElementException("User not found"));
        if (user.getResetPasswordToken() == null) {
            throw new NoSuchElementException("Reset password token not found");
        }

        if (password == null || password.isEmpty() || !Pattern.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,20}$", password)) {
            String message = locale.getLanguage().equals("en")
                    ? "Incorrect password format"
                    : "Неверный формат пароля";
            model.addAttribute("errorMessage", message);
            return "passwordRecovery/change_password";
        }

        usersService.changePassword(password, user);
        return "redirect:/auth/login";
    }
}
