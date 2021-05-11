package com.fun.wombat.model;

import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "fun_tag")
public class Tag {
    @Id
    private Integer id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;
}
