package com.celakd.ofoservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailDetails {
    private final String recipient;
    private String subject;
    private String messageBody;
    private String attachment;

    EmailDetails() {
        this.recipient = "accountmanager@example.com";
    }
}
