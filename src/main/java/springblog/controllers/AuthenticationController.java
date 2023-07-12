package springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springblog.models.User;
import springblog.services.AuthBuddy;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        User loggedInUser = AuthBuddy.getLoggedInUser();
        model.addAttribute("loggedInUser", loggedInUser);

        return "users/login";
    }
}

