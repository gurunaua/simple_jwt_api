package com.example.jwt.demo.service.impl;

import com.example.jwt.demo.exception.FileNotFoundException;
import com.example.jwt.demo.exception.FileStorageException;
import com.example.jwt.demo.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${file.upload-dir}")
    private String fileStorageProperties;

    @Override
    public Path FileStorageService(String path) {
        Path fileStorageLocation = Paths.get(fileStorageProperties + path);

        try {
            Files.createDirectories(fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
        return fileStorageLocation;
    }

    @Override
    public String storeFile(MultipartFile file, String path) {
        if(path==null){
            path = "path-"+file.getOriginalFilename();
        }
        Path fileLocation = FileStorageService(path);
        String temp =   StringUtils.cleanPath(fileLocation.toString());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = fileLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return path + "/" + fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public Resource loadFileAsResource(String path) {
        try {
            Path filePath = Paths.get(fileStorageProperties + path).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found");
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found", ex);
        }
    }
}