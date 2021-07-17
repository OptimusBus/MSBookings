package Service;

public interface BranchLocal {
				
	
public int createBooking(int passengerId,double fromLong,double fromLat,double toLong,double toLat,int vehicleId);
public boolean confirmBooking(String username,int vehicleId,int code);
public int findAllBooking(String username); // metodo che ritorna le prenotazioni in relazione a quel username
public int findAllBookingDate(long timestamp); // metodo che ritorna le prenotazioni in relazione a quella data
public int finAllBookingUs(String username,long timestamp);// metodo che ritorna le prenotazioni del cliente in quella data



	
	
}
