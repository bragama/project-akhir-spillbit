package com.verlin.projectakhir.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "spillbit_tb")
public class Spillbit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "note")
    private String note;

    @JoinColumn(name = "amount")
    private Integer amount;

    @JoinColumn(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user")
    private User user;
}
