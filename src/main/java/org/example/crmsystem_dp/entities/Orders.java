package org.example.crmsystem_dp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "executor_id", nullable = false)
    private Executors executor;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private OrderStatus status = OrderStatus.NEW;

    public enum OrderStatus {
        NEW, IN_PROGRESS, COMPLETED, CANCELLED
    }
}
