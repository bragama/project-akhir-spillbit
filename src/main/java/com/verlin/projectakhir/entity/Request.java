package com.verlin.projectakhir.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request_tb")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "note")
    private String note;

    @JoinColumn(name = "amount")
    private Integer amount;

    @JoinColumn(name = "deadline")
    private String deadline;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user")
    private User user;
}
