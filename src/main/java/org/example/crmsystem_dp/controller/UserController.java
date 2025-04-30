package org.example.crmsystem_dp.controller;

import jakarta.servlet.http.HttpSession;
import org.example.crmsystem_dp.entities.Customers;
import org.example.crmsystem_dp.entities.Users;
import org.example.crmsystem_dp.service.SalesFunnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    HttpSession session;



    @GetMapping("/profile")
    public String viewProfile(HttpSession session, Model model) {
        // Данные пользователя
        Map<String, Object> user = new HashMap<>();
        user.put("username", "John Doe");
        user.put("role", "Admin");
        user.put("phone", "+123456789");

        Map<String, Integer> funnelData = new HashMap<>();
        funnelData.put("Новые лиды", 10);
        funnelData.put("Квалифицированные", 7);
        funnelData.put("Завершенные", 5);

        // Список клиентов
        List<Map<String, String>> clients = List.of(
                Map.of("name", "Alice", "email", "alice@example.com", "status", "Новый"),
                Map.of("name", "Bob", "email", "bob@example.com", "status", "Квалифицированный"),
                Map.of("name", "Charlie", "email", "charlie@example.com", "status", "Завершен")
        );


        // Передаем данные в модель
        model.addAttribute("user", user);
        model.addAttribute("funnelData", funnelData);
        model.addAttribute("clients", clients);

        return "profile";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
