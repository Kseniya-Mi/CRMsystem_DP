package org.example.crmsystem_dp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="users")
public class Users {

    @Id // Помечает поле как первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкремент для id
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="login")// Поле не может быть null и должно быть уникальным
    private String login;

    @Column(name="password") // Поле не может быть null
    private String password;

    @Column(name="role")
    private String role;

    public Users(int id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
