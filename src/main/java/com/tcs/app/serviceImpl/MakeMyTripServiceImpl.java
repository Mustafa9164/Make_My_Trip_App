package com.tcs.app.serviceImpl;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.tcs.app.request.Passenger;
import com.tcs.app.response.Ticket;
import com.tcs.app.service.MakeMyTripService;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService{
	
	private String Book_Ticket_Url="http://localhost:8067/ticket";
	
	private String Get_Ticket_Url="http://localhost:8067/ticket/{id}";
	
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.post()
								.uri(Book_Ticket_Url)
								.bodyValue(passenger)
								.retrieve()
								.bodyToMono(Ticket.class)
								.block();
		return ticket;
		
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.get()
									.uri(Get_Ticket_Url,ticketId) // which url to make get req
									.retrieve()			// retrive the resp from from the body in irtcs
									.bodyToMono(Ticket.class) // map To Ticket.class
									.block(); 				//sync
		return ticket;
	}


//	@Override
//	public Ticket bookTicket(Passenger passenger) {
// 		RestTemplate rt=new RestTemplate();    //send http req to the given url
//		ResponseEntity<Ticket> respEntity = rt.postForEntity(Book_Ticket_Url, passenger, Ticket.class);
//		Ticket ticket = respEntity.getBody();
//		return ticket;
//	}
//
//	@Override
//	public Ticket getTicket(Integer ticketId) {
//		RestTemplate rt=new RestTemplate();
//		ResponseEntity<Ticket> respEntity = rt.getForEntity(Get_Ticket_Url, Ticket.class, ticketId);
//		Ticket ticket = respEntity.getBody();
//		return ticket;
//	}

}
