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
public class Customers {

    @Id
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
}
