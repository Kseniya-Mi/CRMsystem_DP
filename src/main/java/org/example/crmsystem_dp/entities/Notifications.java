package org.example.crmsystem_dp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Notifications {

    @Id
    private int id;
    private String massage;
    private String date;
    private int customer_id;
}
