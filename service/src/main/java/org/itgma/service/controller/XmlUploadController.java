package org.itgma.service.controller;

import org.itgma.service.service.XmlDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/")
public class XmlUploadController {

    @Autowired
    private XmlDataService xmlDataService;

    @PostMapping("upload")
    public void upload(@RequestParam("file") MultipartFile file) {
        xmlDataService.save(file);
    }
}
