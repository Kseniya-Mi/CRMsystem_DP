package org.example.crmsystem_dp.controller;

import jakarta.servlet.http.HttpSession;
import org.example.crmsystem_dp.entities.Orders;
import org.example.crmsystem_dp.entities.Users;
import org.example.crmsystem_dp.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private final OrdersService ordersService;

    public CustomerController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/dashboard")
    public String userDashboard(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("currentUser");
        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("statuses", Orders.OrderStatus.values());
        List<Orders> latestOrders = ordersService.getLatestOrders(3);
        model.addAttribute("latestOrders", latestOrders);
        return "customer/dashboard";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("order", new Orders());
        return "redirect:/orders";
    }

}
