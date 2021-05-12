package com.fun.wombat.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="fun_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="fun_post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "fun_user_id")
    private User user;

    private String content;

}
