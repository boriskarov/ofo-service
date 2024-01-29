package org.itgma.service.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


public interface XmlDataService {

    public ResponseEntity<?> save(MultipartFile file);
}
