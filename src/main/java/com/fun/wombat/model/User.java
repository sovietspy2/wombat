package com.fun.wombat.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "fun_user")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
    private Language language;
    private Long score;
}
