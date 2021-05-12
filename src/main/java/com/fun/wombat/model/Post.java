package com.fun.wombat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fun_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fun_user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    private String contentUrl;

    private String contentText;

    private String title;

    @OneToMany(mappedBy = "post")
    @OrderColumn(name = "entry")
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "fun_post_fun_tag",
            joinColumns = @JoinColumn(name = "fun_post_id"),
            inverseJoinColumns = @JoinColumn(name = "fun_tag_id"))
    private List<Tag> tags;

}
