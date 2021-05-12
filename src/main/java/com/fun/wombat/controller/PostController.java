package com.fun.wombat.controller;

import com.fun.wombat.model.Post;
import com.fun.wombat.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
public class PostController {

    private final PostRepository repository;

    PostController(PostRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin
    @GetMapping("/posts")
    public List<Post> all() {
        return repository.findAll();
    }

    @CrossOrigin
    @PostMapping("/posts/create")
    public ResponseEntity createPost(@RequestPart MultipartFile file, @RequestParam MultiValueMap<String,String> paramMap) {

        //TODO: implement

        // TODO: FTP file upload
        return ResponseEntity.ok().build();

    }

}
