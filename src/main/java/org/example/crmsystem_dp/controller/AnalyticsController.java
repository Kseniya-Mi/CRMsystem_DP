package org.example.crmsystem_dp.controller;

import org.example.crmsystem_dp.entities.Customers;
import org.example.crmsystem_dp.entities.Orders;
import org.example.crmsystem_dp.repository.CustomersRepository;
import org.example.crmsystem_dp.repository.ExecutorsRepository;
import org.example.crmsystem_dp.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/analytics")
public class AnalyticsController {

    private final OrdersRepository orderRepository;
    private final CustomersRepository customerRepository;
    private final ExecutorsRepository executorRepository;


    @Autowired
    public AnalyticsController(OrdersRepository orderRepository,
                               CustomersRepository customerRepository,
                               ExecutorsRepository executorRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.executorRepository = executorRepository;
    }

    @GetMapping
    public String getAnalytics(Model model) {
        // Основные метрики
        model.addAttribute("totalOrders", orderRepository.count());
        model.addAttribute("sum", orderRepository.getTotalRevenue());
        model.addAttribute("activeCustomers", customerRepository.countActiveCustomers());
        model.addAttribute("executorsCount", executorRepository.count());

        model.addAttribute("order", new Orders());

        List<Orders> statusStats = orderRepository.getOrderStatusStats();
        model.addAttribute("statusStats", statusStats);

        // Последние заказы
        model.addAttribute("recentOrders", orderRepository.findTop3ByOrderByCreatedAtDesc());
        model.addAttribute("statuses", Orders.OrderStatus.values());

        return "analytics";
    }

    @PostMapping("/analytics")
    public String postAnalytics(Model model, Orders order) {
        return "/analytics";
    }
}
