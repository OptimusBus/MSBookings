package controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.bson.Document;

import com.mongodb.BasicDBObject;

import model.Booking;
import model.BookingReq;
import model.ConfirmBooking;
import model.Location;
import model.Node;
import service.Branch;
import service.BranchLocal;

@Consumes({"application/json"})
@Produces("application/json")
@Path("/bookings")

public class BookingsController {
	
	public BookingsController() {
		super();
	}
	
	private BranchLocal branch = new Branch();
	
	//@POST
	//@Path("/createeee")
	//public Response createBooking(BookingReq vr) {
	//	return null;
	//}
	
	@PUT
	@Path("/confirm")
	public Response confirmBooking(String request) {
		BasicDBObject d = BasicDBObject.parse(request);
		String bookingId = d.getString("bookingId");
		System.out.println(bookingId);
		Booking v=branch.confirmBookings(bookingId);
		if(v==null) return Response.status(404).build();
		return Response.ok(v).build();
	}
	
	@GET
	@Path("/{bookingId}")
	public Response getBooking(@PathParam("bookingId") String bookingId) {
		System.out.println(bookingId);
		Booking v = branch.getBooking(bookingId);
		if(v == null) return Response.status(404).build();
		return Response.ok(v).build();
	}
	
	@GET
	@Path("/passengers/{passengerId}")
	public Response getAllBookingsById(@PathParam("passengerId")String passengerId) {
		System.out.println(passengerId);
		List<Booking> v=branch.findAllBooking(passengerId);
		if(v==null) return Response.status(404).build();
		return Response.ok(v).build();
		
	}
	
	@GET
	@Path("/status/waiting")
	public Response getAllWaitingBookings() {
		List<Booking> v=branch.findAllWaitingBooking();
		if(v==null) return Response.status(404).build();
		return Response.ok(v).build();
	}
	
	@GET
	@Path("/status/onboard/{vehicleId}")
	public Response getAllOnBoardBookings(@PathParam("vehicleId") String vehicleId) {
		List<Booking> v=branch.findAllOnBoardBooking(vehicleId);
		if(v==null) return Response.status(404).build();
		return Response.ok(v).build();
	}
		
	
	
	@POST
	@Path("/create")
	public Response createBooking(String request) throws URISyntaxException {
		
			BasicDBObject bd = BasicDBObject.parse(request);
			Document d = new Document(bd);
			Document booking = new Document();
			booking.append("bookingId", branch.calcBookingId());
			booking.append("timestamp", ""+Instant.now().getEpochSecond());
			booking.append("isConfirmed", false);
			booking.append("passengerId", d.getString("passengerId"));
			booking.append("vehicleId", d.getString("vehicleId"));
			booking.append("code", branch.calcCode());
			booking.append("departure", d.get("departure"));
			booking.append("destination", d.get("destination"));
			BasicDBObject n1 = BasicDBObject.parse(d.get("departure").toString());
			BasicDBObject n2 = BasicDBObject.parse(d.get("destination").toString());
			BasicDBObject l1 = BasicDBObject.parse(n1.get("location").toString());
			BasicDBObject l2 = BasicDBObject.parse(n2.get("location").toString());
			Document dep = new Document("nodeId", n1.getString("nodeId"));
			dep.append("type", n1.getString("type"));
			dep.append("potentialDemand", n1.getDouble("potentialDemand", 0));
			Document depLoc = new Document("longitude", l1.getDouble("longitude"));
			depLoc.append("latitude", l1.getDouble("latitude"));
			dep.append("location", depLoc);
			booking.append("departure", dep);
			Document dest = new Document("nodeId", n2.getString("nodeId"));
			dest.append("type", n2.getString("type"));
			dest.append("potentialDemand", n2.getDouble("potentialDemand", 0));
			Document destLoc = new Document("longitude", l2.getDouble("longitude"));
			destLoc.append("latitude", l2.getDouble("latitude"));
			dest.append("location", destLoc);
			booking.append("destination", dest);
			Booking b =Booking.decodeBooking(booking);
			branch.createBooking(b);
			if(b==null) return Response.status(500).build();
			return Response.created(new URI("/"+b.getBookingId())).build();
		
	}	
	
	
	
	
	
	
	
	
	

}
