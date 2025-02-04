package com.Anath.ItemDelivery;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private float weight;
    @Column(unique = true)
    private String code;


    @Override
    public String toString(){
        return "Item{" +
                "id=" + id +
                ", name= '" + name + '\'' +
                ", weight = " + weight +
                ", code='" + code + '\'' +
                '}';
    }
}
