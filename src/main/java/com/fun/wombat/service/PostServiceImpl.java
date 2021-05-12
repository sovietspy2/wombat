package com.fun.wombat.service;

import com.fun.wombat.ftp.FtpUploader;
import com.fun.wombat.model.Post;
import com.fun.wombat.model.Tag;
import com.fun.wombat.model.User;
import com.fun.wombat.repository.PostRepository;
import com.fun.wombat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final FtpUploader ftpUploader;

    private final UserRepository userRepository;

    @Override
    public List<Post> loadPosts() {
        return postRepository.findAll();
    }

    @Override
    public void createPost(String title, String contentText, MultipartFile picture, User user, List<Tag> tags) {

        user = new User();
        user.setName(UUID.randomUUID().toString());
        user.setEmail("bobby@bob.xxx");

        userRepository.save(user);

        Post post = Post.builder()
                .title(title)
                .contentText(contentText)
                .user(user)
                .build();

        ftpUploader.uploadPicture(user, picture);
        postRepository.save(post);
    }
}
