package org.example.crmsystem_dp.controller;

import jakarta.persistence.EntityNotFoundException;
import org.example.crmsystem_dp.entities.Orders;
import org.example.crmsystem_dp.service.CustomerService;
import org.example.crmsystem_dp.service.ExecutorsService;
import org.example.crmsystem_dp.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrdersService ordersService;
    private final CustomerService customerService;
    private final ExecutorsService executorsService;

    public OrderController(OrdersService ordersService, CustomerService customerService, ExecutorsService executorsService) {
        this.ordersService = ordersService;
        this.customerService = customerService;
        this.executorsService = executorsService;
    }

    // Получение всех заказов
    @GetMapping
    public String getAllOrders(Model model) {
        List<Orders> orders = ordersService.getAllOrders();
        model.addAttribute("statuses", Orders.OrderStatus.values());
        model.addAttribute("orders", orders); // Добавляем заказы в модель
        return "orders"; // Возвращаем view для отображения
    }

    // Получение конкретного заказа по ID
    @GetMapping("/{id}")
    public String getOrderById(@PathVariable Long id, Model model) {
        Optional<Orders> order = ordersService.getOrderById(id);
        model.addAttribute("statuses", Orders.OrderStatus.values());
        order.ifPresent(o -> model.addAttribute("order", o)); // Добавляем в модель, если заказ найден
        return "orders"; // Страница с деталями заказа
    }

    // Получение заказов по статусу
    @GetMapping("/status/{status}")
    public String getOrdersByStatus(
            @PathVariable Orders.OrderStatus status, Model model) {
        List<Orders> orders = ordersService.getOrdersByStatus(status);
        model.addAttribute("statuses", Arrays.asList("NEW", "IN_PROGRESS", "COMPLETED", "CANCELLED"));
        model.addAttribute("orders", orders);
        return "orders"; // Используем тот же шаблон, но с фильтрацией
    }

    // Получение заказов по дате
    @GetMapping("/date/{date}")
    public String getOrdersByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Model model) {
        List<Orders> orders = ordersService.getOrdersByDate(date);
        model.addAttribute("statuses", Orders.OrderStatus.values());
        model.addAttribute("orders", orders);
        return "orders";
    }

    // Создание нового заказа
    // 1. Показ формы создания (GET)
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("order", new Orders());
        model.addAttribute("statuses", Orders.OrderStatus.values()); // Используем enum
        return "create";
    }

    // 2. Обработка создания (POST)
    @PostMapping("/create")
    public String createOrder(@ModelAttribute("order") Orders orderDto,
                              BindingResult result,
                              RedirectAttributes redirectAttributes) {

        orderDto.getId();
        ordersService.createOrder(orderDto);
        redirectAttributes.addFlashAttribute("success", "Заказ успешно создан!");
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Orders order = ordersService.getOrderById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));
        model.addAttribute("statuses", Orders.OrderStatus.values()); // Используем enum

        model.addAttribute("order", order);
        //model.addAttribute("statuses", Orders.OrderStatus.values());

        return "redactor_order";
    }

    // Обновление заказа
    @PostMapping("/update/{id}")
    public String updateOrder(
            @PathVariable Long id, @ModelAttribute Orders orderDto) {
        ordersService.updateOrder(id, orderDto);
        return "redirect:/orders";
    }

    // Удаление заказа
    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        ordersService.deleteOrder(id);
        return "redirect:/orders";
    }
}
