package com.tobioyelami.foodapp.foodapp.restaurant.controller;

import com.sun.tools.corba.se.idl.InvalidArgument;
import com.tobioyelami.foodapp.foodapp.restaurant.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by toyelami on 05/04/2019
 */
@RestController
@RequestMapping("/v1/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException, InvalidArgument {
        return fileService.getFile(imageName);
    }

    @GetMapping
    public ResponseEntity<byte[]> getImageTest() throws IOException {
        FileSystemResource pathResource = new FileSystemResource("images/image.jpg");
        byte[] bytes = StreamUtils.copyToByteArray(pathResource.getInputStream());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
    }

    @PostMapping
    public ResponseEntity<Boolean> upload(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        return ResponseEntity.ok().body(fileService.save(file) != null);
    }

    @DeleteMapping("{filename:.+}")
    public ResponseEntity<Boolean> delete(@PathVariable("filename") String fileName){
        return ResponseEntity.ok().body(fileService.delete(fileName));
    }
}
