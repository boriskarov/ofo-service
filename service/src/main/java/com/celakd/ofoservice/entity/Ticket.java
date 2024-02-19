package com.celakd.ofoservice.entity;

import com.celakd.ofoservice.enumerate.TicketStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    @Lob
    private String body;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

    public Ticket(){
        this.ticketStatus = TicketStatus.OPEN;
    }
}
