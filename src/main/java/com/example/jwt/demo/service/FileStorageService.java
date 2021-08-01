package com.example.jwt.demo.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileStorageService {
    public Path FileStorageService(String path);
    public String storeFile(MultipartFile file, String path);
    Resource loadFileAsResource(String path);
}
