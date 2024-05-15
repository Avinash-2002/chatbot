//package main.java.com.example.demo.controller;

package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.service.MilvusService;

@RestController
@RequestMapping("/api")
public class UploadController {

    private final MilvusService milvusService;

    public UploadController(MilvusService milvusService) {
        this.milvusService = milvusService;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String content = new String(file.getBytes());
            milvusService.processAndStoreEmbeddings(content);
            return "File processed and embeddings stored.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to process the file.";
        }
    }
}
