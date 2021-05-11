package com.fun.wombat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
public class PostController {

    @PostMapping("/posts/create")
    public ResponseEntity createPost(@RequestPart MultipartFile file, @RequestParam MultiValueMap<String,String> paramMap) {

        //TODO: implement

        // TODO: FTP file upload
        return ResponseEntity.ok().build();

    }

}
