package com.celakd.ofoservice.controller;

import com.celakd.ofoservice.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/mail")
public class EmailController {
    @Autowired
    private MailService mailService;
    @PostMapping("/send")
    public String sendEmailToAccountManager(@RequestParam String subject, @RequestParam String messageBody, @RequestParam(required = false) MultipartFile attachment){
        mailService.sendMailToAccountManager(subject, messageBody, attachment);
        return "E-Mail sent.";
    }
}
