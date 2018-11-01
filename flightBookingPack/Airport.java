package flightBookingPack;

import java.util.Scanner;

public class Airport {
	Scanner s1 = new Scanner(System.in);
	String destination;
	String date;
	int noOfSeats;
	private static Airport obj;
	private Airport(){
		
	}
	static Airport getInstance() {
		if(obj == null)
			obj = new Airport();
		return obj;
	}
	boolean available=false;
    DomesticFlight d1 = new DomesticFlight("Mangalore","4-Nov-2018",30);
    DomesticFlight d2 = new DomesticFlight("Mumbai","5-Nov-2018",30);
    InternationalFlight i1 = new InternationalFlight("USA","5-Nov-2018",50);
    InternationalFlight i2 = new InternationalFlight("Dubai","6-Nov-2018",50);
	Flight[] flightArray= new Flight[] {d1,d2,i1,i2};
	void checkAllAvailableFlights() {
		for(int i = 0 ; i< flightArray.length ; i++) {
			System.out.println("Flight no " + (i+1) + " Details");
			System.out.println("----------------------------");
			System.out.println("Destination -> " + flightArray[i].destination);
			System.out.println("date -> " + flightArray[i].date);
			System.out.println("No of Seats -> " + flightArray[i].noOfSeats);
			System.out.println("----------------------------");
		}
	}
	boolean checkFlights(String destination,String date,int noOfSeats) {
		for(int i= 0 ; i < flightArray.length ; i++) {
			if(flightArray[i].destination.equals(destination) && flightArray[i].date.equals(date) && flightArray[i].noOfSeats >= noOfSeats) {
				available = true;
				return available;
			}
		}
		return available;
	}
	
	void confirmBooking(String destination,String date,int noOfSeats) {
		for(int i= 0 ; i < flightArray.length ; i++) {
			if(flightArray[i].destination.equals(destination) && flightArray[i].date.equals(date) && flightArray[i].noOfSeats >= noOfSeats) {
				flightArray[i].noOfSeats -= noOfSeats;
				System.out.println("Booking confirmed.");
				BoardingPass boardingPassObj = new BoardingPass(destination,date,noOfSeats);
				System.out.println("Press 1 to display your boarding pass details.Press any other key to exit");
				int wantDetails = s1.nextInt();
				if(wantDetails == 1) {
					boardingPassObj.displayMyDetails();
				}
			}
		}
	}
}
