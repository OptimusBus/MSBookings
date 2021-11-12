package db;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import model.Booking;

public class MongoConnector {
	
	public static void close() {
		m.close();
	}
	
	public MongoConnector() {}
	
	
	public List<Document> confirmedBookings(boolean isConfirmed){
		MongoDatabase db= m.getDatabase("BookingsDB");
		MongoCollection<Document> collection = db.getCollection("bookings");
		return collection.find(Filters.eq("isConfirmed",true)).into(new ArrayList<Document>());
		
	}
		
	public void persist (Booking v) {
		Document booking=Booking.encodeBooking(v);
		MongoDatabase db= m.getDatabase("BookingsDB");
		MongoCollection<Document> collection = db.getCollection("bookings");
		collection.insertOne(booking);
                		
                
	}
	public void updateBookings (Booking v) {
		Document booking=Booking.encodeBooking(v);
		MongoDatabase db= m.getDatabase("BookingsDB");
		MongoCollection<Document> collection = db.getCollection("bookings");
		collection.replaceOne(Filters.eq("bookingId", v.getBookingId()), booking);
		
	
	}
	
	public List<Document> allBookingsByPassengerId(String passengerId){
		MongoDatabase db= m.getDatabase("BookingsDB");
		MongoCollection<Document> collection = db.getCollection("bookings");
		Bson condition = new Document("isConfirmed",true);
	    Bson filter = new Document("passengerId", condition);
	   return collection.find(filter).into(new ArrayList<Document>());
	}
	
	
	public long getBookingsCount() {
		MongoDatabase db = m.getDatabase("BookingsDB");
		MongoCollection<Document> coll = db.getCollection("bookings");
		return coll.count();
	}
	
	public Document getBookingsById(String bookingId){
		MongoDatabase db = m.getDatabase("BookingsDB");
		MongoCollection<Document> coll = db.getCollection("bookings");
		//System.out.println(coll.find(Filters.eq("bookingsId", bookingId)).first().toJson());
		return coll.find(Filters.eq("bookingId", bookingId)).first();
	}
	
	
	public List<Document> getAllWaitingBookings(){
		MongoDatabase db= m.getDatabase("BookingDB");
		MongoCollection<Document> coll=db.getCollection("bookings");
		return coll.find(Filters.eq("status", "WAITING")).into(new ArrayList<Document>());
				
	}
	

	public List<Document> getAllOnBoardBookings(String vehicleId){
		MongoDatabase db= m.getDatabase("BookingDB");
		MongoCollection<Document> coll=db.getCollection("bookings");
		BasicDBObject criteria=new BasicDBObject();
		criteria.append("vehicleId", vehicleId);
		criteria.append("status", "ONBOARD");
		return coll.find(criteria).into(new ArrayList<Document>());
				
	}
	
	
	
	private static final MongoClient m= new MongoClient("137.121.170.248", 31186);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


