package org.example.crmsystem_dp.controller;

import jakarta.servlet.http.HttpSession;
import org.example.crmsystem_dp.entities.DashboardStats;
import org.example.crmsystem_dp.entities.Orders;
import org.example.crmsystem_dp.entities.Users;
import org.example.crmsystem_dp.service.OrdersService;
import org.example.crmsystem_dp.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/executor")
public class ExecutorController {

    @Autowired
    private final OrdersService ordersService;
    private final StatsService statsService;

    public ExecutorController(OrdersService ordersService, StatsService statsService) {
        this.ordersService = ordersService;
        this.statsService = statsService;
    }

    @GetMapping("/dashboard")
    public String adminDashboard(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("currentUser");
        if (user == null || !"ADMIN".equals(user.getRole())) {
            return "redirect:/login";
        }

        DashboardStats stats = statsService.getDashboardStats();
        model.addAttribute("stats", stats);
        model.addAttribute("statuses", Orders.OrderStatus.values());
        List<Orders> latestOrders = ordersService.getLatestOrders(3);
        model.addAttribute("latestOrders", latestOrders);
        return "executor/dashboard";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("order", new Orders());
        return "redirect:/orders";
    }

}
