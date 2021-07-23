package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookingReq {
	
	
	public BookingReq(String passengerId, String vehicleId, Node departure, Node destination) {
		super();
		this.passengerId = passengerId;
		this.vehicleId = vehicleId;
		this.departure = departure;
		this.destination = destination;
	}
	
	

	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
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

	private String passengerId;
	private String vehicleId;
	public Node departure;
	public Node destination;
	
	
	
}
