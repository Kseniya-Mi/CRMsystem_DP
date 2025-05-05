package org.example.crmsystem_dp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customer;

    @Column(name = "executor_id", nullable = false)
    private Long executor;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(20) NOT NULL")
    private OrderStatus status= OrderStatus.NEW;;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "sum")
    private Double sum;

    public enum OrderStatus {
        NEW, IN_PROGRESS, COMPLETED, CANCELLED
    }
}
