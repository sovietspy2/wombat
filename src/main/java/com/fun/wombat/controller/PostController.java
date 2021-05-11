package com.fun.wombat.controller;

import com.fun.wombat.model.Post;
import com.fun.wombat.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Controller
public class PostController {

    private final PostRepository repository;

    PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/posts")
    List<Post> all() {
        return repository.findAll();
    }

    @PostMapping("/posts/create")
    public ResponseEntity createPost(@RequestPart MultipartFile file, @RequestParam MultiValueMap<String,String> paramMap) {

        //TODO: implement

        // TODO: FTP file upload
        return ResponseEntity.ok().build();

    }

}
