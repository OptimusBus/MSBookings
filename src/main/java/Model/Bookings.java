package Model;

import java.time.Instant;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Bookings {
	

	public Bookings(Node departure, Node destination, int bookingId, int passengerId, int vehicleId, int code,
			boolean isConfirmed) {
		super();
		this.departure = departure;
		this.destination = destination;
		this.bookingId = bookingId;
		this.passengerId = passengerId;
		this.vehicleId = vehicleId;
		this.code = code;
		this.isConfirmed = isConfirmed;
	}
	
	public Node getDeparture() {
		return departure;
	}
	public void setDeparture(Node departure) {
		this.departure = departure;
	}
	public Node getDestination() {
		return destination;
	}
	public void setDestination(Node destination) {
		this.destination = destination;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public boolean isConfirmed() {
		return isConfirmed;
	}
	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	
	public Node departure;
	public Node destination;
	private int bookingId;
	private int passengerId;
	private int vehicleId;
	private int code;
	private long timestamp=Instant.now().getEpochSecond();
	private boolean isConfirmed=false;
	
	
	
}
