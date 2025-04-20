package org.example.crmsystem_dp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Users {

    @Id
    private int id;
    private String login;
    private String password;
    private String role;
}
