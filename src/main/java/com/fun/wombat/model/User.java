package com.fun.wombat.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "fun_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Language language;
    private Integer score;
}
