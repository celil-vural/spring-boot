package com.springbootgridfsfileupload.controller;

import com.springbootgridfsfileupload.service.FileUploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {
    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping
    public void fileUpload(@RequestParam MultipartFile file) throws IOException {
        System.out.println("File Name: " + file.getOriginalFilename());
        System.out.println("File Size: " + file.getSize());
        fileUploadService.fileUpload(file);
    }
}
