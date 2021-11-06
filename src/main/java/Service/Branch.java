package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.faces.flow.builder.ReturnBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.bson.Document;

import db.MongoConnector;
import model.Booking;
import model.Location;
import model.Node;

public class Branch implements BranchLocal {
	
	MongoConnector m=new MongoConnector();
	
	public Branch() {}
	
	
	
	
	
	
	
	public Booking confirmBookings(String bookingId) {
		Booking v = Booking.decodeBooking(m.getBookingsById(bookingId));
		v.setConfirmed(true);
		m.updateBookings(v);
		return v;
	}
	

	

	public Booking getBooking(String bookingId) {
		Document v=m.getBookingsById(bookingId);
		return Booking.decodeBooking(v);
		
	}
	
	public String calcBookingId() {
		
		long c= m.getBookingsCount();
		c++;
		
		String a= ""+c;
		int l=a.length();
		String id= "";
		if(l<2) id ="B"+ "00000"+a;
		else if(l<3) id= "B" + "0000"+a;
		else if(l<4) id= "B" + "000"+a;
		else if(l<5) id= "B" + "00"+a;
		else if(l<6) id= "B" + "0" +a;
		else id="B"+a;
	
		return id;
	}

	
	public List<Booking> findAllBooking(String passengerId) {
		List<Document> ld = m.allBookingsByPassengerId(passengerId);
		List<Booking> lv = new ArrayList<Booking>();
		for(Document d : ld) {
			lv.add(Booking.decodeBooking(d));
		}
		return lv;
	}

	public Booking createBooking(Booking b) {
		
		m.persist(b);
		return b;
	}
	
	public int calcCode() {
		return 100000 + (new Random().nextInt(900000));
	}
	
	public List<Booking> findAllWaitingBooking(){
		List<Document> ld = m.getAllWaitingBookings();
		List<Booking> lv = new ArrayList<Booking>();
		for(Document d : ld) {
			lv.add(Booking.decodeBooking(d));
		}
		return lv;
	
	}
	
	public List<Booking> findAllOnBoardBooking(String vehicleId){
		List<Document> ld = m.getAllOnBoardBookings(vehicleId);
		List<Booking> lv = new ArrayList<Booking>();
		for(Document d : ld) {
			lv.add(Booking.decodeBooking(d));
		}
		return lv;
	
	}






	

}
	