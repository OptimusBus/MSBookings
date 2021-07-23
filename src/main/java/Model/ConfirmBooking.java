package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConfirmBooking {
	
	public ConfirmBooking(String username, int vehicleId, int code) {
		super();
		this.username = username;
		this.vehicleId = vehicleId;
		this.code = code;
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	private String username;
	private int vehicleId;
	private int code;
	
}
