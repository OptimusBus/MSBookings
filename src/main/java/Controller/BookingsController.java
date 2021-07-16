package Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import Model.BookingReq;
import Model.ConfirmBooking;
import Model.Node;

@Consumes({"application/json"})
@Produces("application/json")
@Path("/bookings")

public class BookingsController {
	
	public BookingsController() {
	super();
	}
	
	@POST
	@Path("/create")
	public Response createBooking(BookingReq vr) {
		return null;
	}
	
	@PUT
	@Path("/confirm")
	public Response confirmBooking(ConfirmBooking s) {
		return null;
	}
	
	
	
	
	
	
	

}
