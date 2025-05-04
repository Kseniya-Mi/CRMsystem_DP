package org.example.crmsystem_dp.controller;

import jakarta.servlet.http.HttpSession;
import org.example.crmsystem_dp.entities.Users;
import org.example.crmsystem_dp.repository.UsersRepository;
import org.example.crmsystem_dp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    HttpSession session;

    @Autowired
    private UserService userService;

    @Autowired
    private UsersRepository usersRepository;

       @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        Optional<Users> userOptional = userService.authenticate(username, password);
        Users user = userOptional.get();


        if (user != null) {
            session.setAttribute("currentUser", user);

            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/executor/dashboard";
            } else {
                return "redirect:/customer/dashboard";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Неверные учетные данные");
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/welcome")
    public String welcome() {
           return "welcome";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute("user") Users userDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        try {
            userService.registerUser(userDto);
            if(userDto.getRole().equals("ADMIN")) {
                return "redirect:/executor/dashboard";
            } else {
                return "redirect:/customer/dashboard";
            }
        } catch (IllegalArgumentException e) {
            return "/register";
        }
    }
}
