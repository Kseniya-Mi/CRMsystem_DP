package org.example.crmsystem_dp.controller;

import jakarta.servlet.http.HttpSession;
import org.example.crmsystem_dp.entities.Users;
import org.example.crmsystem_dp.repository.UsersRepository;
import org.example.crmsystem_dp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    HttpSession session;

    @Autowired
    private UserService userService;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/profile/{id}")
    public String viewProfile(@PathVariable Long id, Model model) {

        Optional<Users> userOptional = usersRepository.findByID(id);

        Users user = userOptional.get();

        //model.addAttribute("login",user.getLogin());
        //model.addAttribute("password",user.getPassword());
        //model.addAttribute("role",user.getRole());
        //model.addAttribute("ID",user.getId());

        model.addAttribute("user", user);

        return "profile";
    }

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

}
