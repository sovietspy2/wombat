package com.fun.wombat.model;

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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fun_user_id")
    private User user;

    private String contentUrl;

    private String content;

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
