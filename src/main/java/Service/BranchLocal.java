package service;

import java.util.List;
import java.util.Random;

import model.Booking;
import model.Node;

public interface BranchLocal {
				
public int calcCode() ;
public Booking createBooking(Booking b);
public Booking confirmBookings(String bookingId);
public Booking getBooking(String bookingId); 
public String calcBookingId();
public List<Booking> findAllBooking(String passengerId); // metodo che ritorna le prenotazioni in relazione a quel username
public List<Booking> findAllWaitingBooking();
public List<Booking> findAllOnBoardBooking(String vehicleId);





	
	
}
