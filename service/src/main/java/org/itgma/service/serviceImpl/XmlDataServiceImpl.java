package org.itgma.service.serviceImpl;

import org.itgma.service.entity.XmlData;
import org.itgma.service.repo.XmlDataRepo;
import org.itgma.service.service.XmlDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class XmlDataServiceImpl implements XmlDataService {

    @Autowired
    private XmlDataRepo xmlDataRepo;

    @Override
    public ResponseEntity<?> save(MultipartFile file) {
        XmlData xmlData = new XmlData();

        try {
            xmlData.setData(file.getBytes());
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Unable to read file", e);
        }

        try {
            xmlDataRepo.save(xmlData);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Unable to save file to database", e);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
