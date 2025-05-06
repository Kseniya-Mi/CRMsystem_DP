package org.example.crmsystem_dp.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
public class DashboardStats {
    private final int clientCount;
    private final int orderCount;
    private final BigDecimal totalRevenue;
}
