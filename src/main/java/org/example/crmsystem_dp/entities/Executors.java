package org.example.crmsystem_dp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="executors")
public class Executors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "skills", nullable = false)
    private String skills; // Например, "Программирование, Дизайн"

    @Column(name = "status", nullable = false)
    private String status; // Например, "Доступен", "Занят"
}
