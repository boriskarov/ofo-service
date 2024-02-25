package com.celakd.ofoservice.service;

import com.celakd.ofoservice.entity.EmailDetails;

public interface MailService {
    void sendMailToAccountManager(EmailDetails emailDetails);
}
