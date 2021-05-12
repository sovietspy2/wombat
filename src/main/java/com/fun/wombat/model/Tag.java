package com.fun.wombat.model;

import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "fun_tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;
}
