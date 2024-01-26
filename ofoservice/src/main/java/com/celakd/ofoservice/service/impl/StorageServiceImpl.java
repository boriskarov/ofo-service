package com.celakd.ofoservice.service.impl;

import com.celakd.ofoservice.exception.StorageException;
import com.celakd.ofoservice.properties.StorageProperties;
import com.celakd.ofoservice.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class StorageServiceImpl implements StorageService {

    private final Path rootLocation;


    public StorageServiceImpl(StorageProperties properties){
        if(properties.getLocation().trim().isEmpty()){
            throw new StorageException("File upload location cannot be empty.");
        }
        this.rootLocation = Paths.get(properties.getLocation());
    }


    @Override
    public void save(MultipartFile file) {
        if(file.isEmpty()){
            throw new StorageException("Cannot store empty file.");
        }
        Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename())).normalize().toAbsolutePath();
        if(!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())){
            throw new StorageException("Cannot store file outside current directory.");
        }
        try(InputStream inputStream = file.getInputStream()){
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        }
        catch(IOException e){
            throw new StorageException("Failed to store file.");
        }
    }

}
