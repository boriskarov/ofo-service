package org.itgma.service.service;

import org.itgma.service.entity.XmlData;
import org.itgma.service.repo.XmlDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface XmlDataService {

    public ResponseEntity<?> save(MultipartFile file);
}
