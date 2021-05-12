package com.fun.wombat.controller;

import com.fun.wombat.model.Post;
import com.fun.wombat.repository.PostRepository;
import com.fun.wombat.repository.UserRepository;
import com.fun.wombat.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @CrossOrigin
    @GetMapping("/posts")
    public List<Post> all() {
        return postService.loadPosts();
    }

    @CrossOrigin
    @PostMapping("/posts/create")
    public ResponseEntity createPost(@RequestPart MultipartFile file, @RequestParam MultiValueMap<String, String> paramMap) {

        //TODO: implement

        // TODO: FTP file upload
        postService.createPost(paramMap.get("title").toString(), paramMap.get("contentText").toString(), file, null, Collections.emptyList());
        return ResponseEntity.ok().build();

    }

}
