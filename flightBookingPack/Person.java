package flightBookingPack;
import java.util.Scanner;
public class Person {
	
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		Airport airportObj = Airport.getInstance();
		System.out.println("Press 1 to attend a customer");
		int nextCust = s1.nextInt();
		while(nextCust == 1) {
		airportObj.checkAllAvailableFlights();
		System.out.println("Enter the Destination");
		String destination = s1.next();
		System.out.println("Enter the date");
		String date = s1.next();
		System.out.println("Enter the no of seats");
		int noOfSeats = s1.nextInt();
		
		boolean available = airportObj.checkFlights(destination,date,noOfSeats);
		if(available) {
			airportObj.available = false;
			System.out.println("Your requested flight is available");
			System.out.println("Press 1 to confirm your booking");
			System.out.println("Press any other number to cancle");
			int choice = s1.nextInt();
			if(choice == 1) {
				airportObj.confirmBooking(destination,date,noOfSeats);
			}else {
				System.out.println("Booking Cancelled");
				
			}
		}else {
			System.out.println("Sorry! Your requested flight is not available");
		}
		System.out.println("Press 1 to attend a customer");
		nextCust = s1.nextInt();
		}
		s1.close();
}
}