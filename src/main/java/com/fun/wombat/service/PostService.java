package com.fun.wombat.service;

import com.fun.wombat.model.Post;
import com.fun.wombat.model.Tag;
import com.fun.wombat.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {

    List<Post> loadPosts();

    void createPost(String title, String contentText, MultipartFile picture, User user, List<Tag> tags);

}
