package Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Model.Bookings;
import Model.Node;

@Stateless
public class Branch implements BranchLocal {
	
	@PersistenceContext
	EntityManager em;
	public Branch() {}
	
	

	@Override
	public int createBooking(int passengerId, double fromLong, double fromLat, double toLong, double toLat,
			int vehicleId) {
		
		int c= em.createNamedQuery("Bookings.countBookings",Integer.class).getSingleResult();
		c++;
		
		String a= " "+c;
		int l=a.length();
		String id= " ";
		if(l<2) id ="B"+ "00000"+a;
		else if(l<3) id= "B" + "0000"+a;
		else if(l<4) id= "B" + "000"+a;
		else if(l<5) id= "B" + "00"+a;
		else if(l<6) id= "B" + "0" +a;
		else id="B"+a;
		
		
		
		
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean confirmBooking(String username, int vehicleId, int code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findAllBooking(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findAllBookingDate(long timestamp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int finAllBookingUs(String username, long timestamp) {
		// TODO Auto-generated method stub
		return 0;
	}

}
