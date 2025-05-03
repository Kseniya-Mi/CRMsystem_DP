package org.example.crmsystem_dp.controller;

import jakarta.servlet.http.HttpSession;
import org.example.crmsystem_dp.entities.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/dashboard")
    public String userDashboard(HttpSession session) {
        Users user = (Users) session.getAttribute("currentUser");
        if (user == null) {
            return "redirect:/login";
        }
        return "customer/dashboard";
    }


}
