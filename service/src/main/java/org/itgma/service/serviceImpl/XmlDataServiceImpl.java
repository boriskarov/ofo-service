package org.itgma.service.serviceImpl;

import org.itgma.service.service.XmlDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class XmlDataServiceImpl implements XmlDataService {

    @Value("${upload.directory}")
    private String uploadDirectory;

    @Override
    public ResponseEntity<?> save(MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload", HttpStatus.BAD_REQUEST);
        }

        try {
            // Create the upload directory if it doesn't exist
            Path directory = Paths.get(uploadDirectory);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            // Save the file to the upload directory
            String fileName = file.getOriginalFilename();
            Path filePath = directory.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

            return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
