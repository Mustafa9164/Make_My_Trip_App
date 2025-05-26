package com.tcs.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.app.request.Passenger;
import com.tcs.app.response.Ticket;
import com.tcs.app.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService service;
	
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam Integer ticketId, Model model) {
		Ticket ticket = service.getTicket(ticketId);
		model.addAttribute("ticket",ticket);
		return "ticket-form";
	}
	
	@GetMapping("/ticket")
	public String getTicketForm(Model model) {
		model.addAttribute("ticket",new Ticket());
		return "ticket-form";
	}
	
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute("passanger") Passenger passenger, Model model) {
		Ticket ticket = service.bookTicket(passenger);
		model.addAttribute("msg","your ticket Booked with Id : "+ticket.getTicketNum());
		return "index";
	}
	
	@GetMapping("/")
	public String loadForm(Model model) {
		
		model.addAttribute("passanger",new Passenger());
		return "index";
	}

}
