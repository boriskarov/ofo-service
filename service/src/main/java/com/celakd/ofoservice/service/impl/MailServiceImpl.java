package com.celakd.ofoservice.service.impl;

import com.celakd.ofoservice.entity.EmailDetails;
import com.celakd.ofoservice.service.MailService;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String sender;


    // change the spring email settings in app properties and the recipient in the EmailDetails entity
    @Override
    public void sendMailToAccountManager(EmailDetails emailDetails) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDetails.getRecipient()));
                mimeMessage.setFrom(new InternetAddress(sender));
                mimeMessage.setSubject(emailDetails.getSubject());
                if (emailDetails.getAttachment() != null) {
                    FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));
                    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                    helper.setText(emailDetails.getMessageBody(), true);
                    helper.addAttachment(file.getFilename(), file);
                }
                else{
                    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                    helper.setText(emailDetails.getMessageBody(), true);
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
