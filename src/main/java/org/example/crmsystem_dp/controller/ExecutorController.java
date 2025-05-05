package org.example.crmsystem_dp.controller;

import jakarta.servlet.http.HttpSession;
import org.example.crmsystem_dp.entities.Orders;
import org.example.crmsystem_dp.entities.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/executor")
public class ExecutorController {

    @GetMapping("/dashboard")
    public String adminDashboard(HttpSession session) {
        Users user = (Users) session.getAttribute("currentUser");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }
        return "executor/dashboard";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("order", new Orders());
        return "redirect:/orders";
    }

}
