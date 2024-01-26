package com.celakd.ofoservice.controller;

import com.celakd.ofoservice.service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class FileUploadController {
    private final StorageService storageService;

    @PostMapping("/upload")
    public String uploadAttachment(@RequestParam("file")MultipartFile file){
        storageService.save(file);
        return "File successfully uploaded!";
    }

}
