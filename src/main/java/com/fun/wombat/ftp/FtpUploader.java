package com.fun.wombat.ftp;

import com.fun.wombat.model.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FtpUploader {

    @Async
    public void uploadPicture(User user, MultipartFile file) {
        ///ftpUploader
        System.out.println("LOL");
    }

}
