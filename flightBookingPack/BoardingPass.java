package flightBookingPack;

public class BoardingPass {
String destination;
String date;
int noOfSeats;
public BoardingPass(String destination, String date, int noOfSeats) {
	this.destination = destination;
	this.date = date;
	this.noOfSeats = noOfSeats;
}

void displayMyDetails() {
	System.out.println("Hello User");
	System.out.println("Your Flight to " + destination + " on " + date + " with " +noOfSeats+ " no of seats has been confirmed" );
}

}
