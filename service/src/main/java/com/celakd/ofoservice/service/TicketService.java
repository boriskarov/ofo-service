package com.celakd.ofoservice.service;

import com.celakd.ofoservice.entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket createTicket(Ticket ticket);
    void editTicket(Long id, Ticket ticket);
    void deleteTicket(Long id);
    Ticket getTicketById(Long id);
    void closeTicketById(Long id);
    List<Ticket> getAllTickets();
}
