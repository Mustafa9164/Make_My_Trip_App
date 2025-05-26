package com.tcs.app.service;

import com.tcs.app.request.Passenger;
import com.tcs.app.response.Ticket;

public interface MakeMyTripService {
	
	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketId);

}
