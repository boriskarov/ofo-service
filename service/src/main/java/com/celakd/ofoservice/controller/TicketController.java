package com.celakd.ofoservice.controller;

import com.celakd.ofoservice.entity.Ticket;
import com.celakd.ofoservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @PutMapping("/{id}/edit")
    public String editTicket(@PathVariable Long id, @RequestBody Ticket ticket){
        ticketService.editTicket(id, ticket);
        return "Ticket saved";
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
        return "Ticket deleted.";
    }

    @PostMapping("/{id}/close")
    public String closeTicket(@PathVariable Long id){
        ticketService.closeTicketById(id);
        return "Ticket closed";
    }
}
