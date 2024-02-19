package com.celakd.ofoservice.service.impl;

import com.celakd.ofoservice.entity.Ticket;
import com.celakd.ofoservice.enumerate.TicketStatus;
import com.celakd.ofoservice.exception.TicketException;
import com.celakd.ofoservice.repository.TicketRepository;
import com.celakd.ofoservice.service.TicketService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    private static final String TICKET_NO_EXIST = "Ticket does not exist";

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    @Transactional
    public void editTicket(Long id, Ticket ticket) {
        if (!ticketRepository.existsById(id)) {
            throw new TicketException(TICKET_NO_EXIST);
        }
        ticket.setId(id);
        ticketRepository.save(ticket);
    }

    @Override
    @Transactional
    public void deleteTicket(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new TicketException(TICKET_NO_EXIST);
        }
        ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> getAllTickets() {
        if (ticketRepository.findAll().isEmpty()) {
            throw new TicketException("There are no tickets at this time.");
        }
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new TicketException(TICKET_NO_EXIST);
        }
        return ticketRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void closeTicketById(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new TicketException(TICKET_NO_EXIST);
        }
        Ticket ticket = ticketRepository.findById(id).get();
        ticket.setId(id);
        ticket.setTicketStatus(TicketStatus.RESOLVED);
        ticketRepository.save(ticket);
    }
}
