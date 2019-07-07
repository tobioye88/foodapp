package com.tobioyelami.foodapp.foodapp.restaurant.service;

import com.sun.tools.corba.se.idl.InvalidArgument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by toyelami on 07/04/2019
 */
@Service
public class FileService {

    @Value("${upload.folder:images/}")
    private String uploadFolder;

    private Logger logger = LoggerFactory.getLogger(FileService.class);

    public File save(MultipartFile file) throws FileNotFoundException {
        return save(file, true);
    }

    public File save(MultipartFile file, boolean autoGenerateName) throws FileNotFoundException {
        String fileName;

        if(autoGenerateName){
            try {
                fileName = UUID.randomUUID() + "." + getExtension(file.getOriginalFilename());
            } catch (InvalidArgument invalidArgument) {
                fileName = file.getOriginalFilename();
                logger.error("Invalid File name");
            }
        }else {
            fileName = file.getOriginalFilename();
        }
        return save(file, fileName);
    }

    public File save(MultipartFile file, String newFileName) throws FileNotFoundException {
        if(file == null){
            throw new FileNotFoundException();
        }

        String fileName = newFileName == null ? file.getOriginalFilename() : newFileName;
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFolder + fileName);
            Files.write(path, bytes);
            return path.toFile();
        } catch (IOException e) {
            logger.error("Could not save file", e);
            throw new FileNotFoundException(e.getLocalizedMessage());
        }
    }

    public byte[] get(String fileName) throws FileNotFoundException {
        FileSystemResource pathResource = new FileSystemResource(uploadFolder + fileName);
        try {
            return StreamUtils.copyToByteArray(pathResource.getInputStream());
        } catch (IOException e) {
            String errorMessage = String.format("%s file could not be found", fileName);
            throw new FileNotFoundException(errorMessage);
        }
    }

    public ResponseEntity<byte[]> getFile(String fileName) throws IOException, InvalidArgument {
        File file = new File(uploadFolder + fileName);
        String contentType = new MimetypesFileTypeMap().getContentType(file);
        MediaType mediaType = MediaType.valueOf(contentType);
        return ResponseEntity.ok().contentType(mediaType).body(get(fileName));
    }

    public boolean delete(String fileName){
        File file = new File(new FileSystemResource(uploadFolder + fileName).getPath());
        try {
            return file.exists() && Files.deleteIfExists(file.toPath());
        } catch (IOException e) {
            logger.error("File could not be deleted", e);
        }
        return false;
    }

    public String getExtension(@NotNull String fileName) throws InvalidArgument {

        int lastIndexOfDot = fileName.lastIndexOf('.');
        if(lastIndexOfDot < 0){
            throw new InvalidArgument("File name is not valid");
        }

        return fileName.substring(lastIndexOfDot+1, fileName.length());

    }
}
