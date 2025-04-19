package benmoncast.com.googleLogin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class AuthController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, @AuthenticationPrincipal OAuth2User oauthUser) {
        if (oauthUser != null) {
            model.addAttribute("name", oauthUser.getAttribute("name"));
            model.addAttribute("email", oauthUser.getAttribute("email"));
            model.addAttribute("picture", oauthUser.getAttribute("picture"));
        }
        return "dashboard";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws IOException {
        // Invalidate session
        request.getSession().invalidate();

        // Clear authentication
        SecurityContextHolder.clearContext();

        // Optional: Show a logout message
        redirectAttributes.addFlashAttribute("logoutMessage", "You have successfully logged out.");

        return "redirect:/logout";
    }

    @GetMapping("/logout")
    public String logoutSuccess(Model model) {
        model.addAttribute("message", "You have successfully logged out.");
        return "logout";
    }
}
