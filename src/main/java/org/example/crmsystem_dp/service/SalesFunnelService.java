package org.example.crmsystem_dp.service;

import org.example.crmsystem_dp.entities.Customers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalesFunnelService {

    public List<Customers> getAllClients() {
        // Логика получения клиентов из базы данных
        return List.of(
                new Customers(1L,"", "John Doe", "john@example.com", "Новый"),
                new Customers(2L,"", "Jane Smith", "jane@example.com", "Квалифицированный")
        );
    }

    public Map<String, Integer> calculateSalesFunnel() {
        // Логика расчета воронки продаж
        return Map.of(
                "Новые лиды", 10,
                "Квалифицированные", 7,
                "Завершенные", 5
        );
    }
}
