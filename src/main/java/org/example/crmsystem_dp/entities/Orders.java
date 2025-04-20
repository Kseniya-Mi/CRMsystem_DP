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
public class Orders {

    @Id
    private int order_id;
    private int customer_id;
    private String tittle;
    private int sum;
    private String order_date;
    private String status;
}
