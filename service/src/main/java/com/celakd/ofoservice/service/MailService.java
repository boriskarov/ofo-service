package com.celakd.ofoservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface MailService {
    void sendMailToAccountManager(String subject, String messageBody, MultipartFile attachment);
}
