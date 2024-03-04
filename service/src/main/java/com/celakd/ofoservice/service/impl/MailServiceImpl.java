package com.celakd.ofoservice.service.impl;

import com.celakd.ofoservice.service.MailService;
import jakarta.activation.DataSource;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;
    // change the recipient below and spring email settings in app properties
    private static final String recipient = "accountmanager@example.com";


    @Override
    public void sendMailToAccountManager(String subject, String messageBody, MultipartFile attachment) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                mimeMessage.setFrom(new InternetAddress(sender));
                mimeMessage.setSubject(subject);
                if (attachment != null) {
                    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                    helper.setText(messageBody, true);
                    DataSource dataSource = new ByteArrayDataSource(attachment.getInputStream(), attachment.getContentType());
                    helper.addAttachment(attachment.getOriginalFilename(), dataSource);
                }
                else{
                    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false);
                    helper.setText(messageBody, true);
                }
            }
        };
        try {
            mailSender.send(preparator);
        } catch (MailSendException e) {
            throw new MailSendException("Could not send message");
        }
    }
}
