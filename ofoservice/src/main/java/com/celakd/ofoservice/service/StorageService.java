package com.celakd.ofoservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void save(MultipartFile file);

}
