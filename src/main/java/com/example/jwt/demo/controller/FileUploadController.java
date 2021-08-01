package com.example.jwt.demo.controller;

import com.example.jwt.demo.payload.response.Response;
import com.example.jwt.demo.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping(value = "/api/uploadFile", method = RequestMethod.POST)
    public Response<String> uploadFile(@RequestParam("file") MultipartFile file) {

        Response response = new Response<String>();
        String filePath = null;

        try {
            filePath = fileStorageService.storeFile(file, null);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage(e.getMessage());
            response.setData(null);
            return response;
        }

        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(filePath);
        return response;
    }

    @RequestMapping(value = "/api/uploadMultiFile", method = RequestMethod.POST)
    public Response<String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
                                            @RequestParam("path") String path) {
        Response response = new Response<String>();
        List<MultipartFile> listFile = Arrays.asList(files);
        List<String> filesPath = null;

        try {
            filesPath = listFile.stream().map(file -> fileStorageService.storeFile(file, path)).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage(e.getMessage());
            response.setData(null);
            return response;
        }

        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Success");
        response.setData(filesPath);
        return response;
    }
}
