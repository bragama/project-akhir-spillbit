package com.verlin.projectakhir.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "spillbit_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "username")
    private String username;

    @JoinColumn(name = "email")
    private String email;

    @JoinColumn(name = "password")
    private String password;

    @OneToMany
    @JsonIgnore
    private List<Send> send;

    @OneToMany
    @JsonIgnore
    private List<Spillbit> spillbits;

    @OneToMany
    @JsonIgnore
    private List<Request> requests;

}
