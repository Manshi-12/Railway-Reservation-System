import java.util.*;
import java.util.Scanner;
import java.util.Date;

public class RailwayReservationSystem 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
		
		Reservation r = new Reservation();
		r.login();
		r.data();
		
        while (true) 
		{
            System.out.println("1. Check seat availability");
            System.out.println("2. Book a seat");
            System.out.println("3. Exit");
			
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
			System.out.println();

            switch (choice) 
			{
                case 1:
				{
                    r.checkAvailability();
                    break;
				}
                case 2:
				{
                    r.bookSeat();
                    break;
				}
				case 3:
				{
                    System.exit(0);
				}
                default:
				{
                    System.out.println("Invalid choice. Try again.");
                    break;
				}
            }
        }
    }
}

class Reservation
{
	static int[] seats = new int[10]; 
    static int totalSeats = 10; 
	String name;
	String from;
	String to;
	int age;
	
    void login()
	{
		System.out.println();
		System.out.println("---Welcome to the L.J train reservation system---");
		System.out.println();
	}
	
	void data()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter required data");
		
		System.out.print("NAME: ");
		name=sc.nextLine();
		
		System.out.print("AGE: ");
		age=sc.nextInt();
		
		System.out.print("Travel FROM: ");
		sc.nextLine();
		from=sc.nextLine();
		
		System.out.print("Travel TO: ");
	    to=sc.nextLine();
		
		System.out.println();
	}
	
	static void checkAvailability() 
	{
		
        int availableSeats = 0;
        for (int i = 0; i < totalSeats; i++) 
		{
            if (seats[i] == 0) 
			{
                availableSeats++;
            }
        }
        System.out.println("Total seats available: " + availableSeats);
    }

    void bookSeat() 
	{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter seat number (1-10): ");
        int seatNumber = sc.nextInt();

        if (seatNumber < 1 || seatNumber > totalSeats) 
		{
            System.out.println("Invalid seat number. Try again.");
            return;
        }

        if (seats[seatNumber - 1] == 1) 
		{
            System.out.println("Seat already booked. Try another seat.");
            return;
        }

        seats[seatNumber - 1] = 1;
		this.printBoardingPass(name,age,from,to,seatNumber);
    }
	
	void printBoardingPass(String name,int age, String from,String to, int seatNumber) 
	{
		Date timenow = new Date();
		System.out.println();
		System.out.println("!!!! Booking Details !!!!");
		System.out.println("Date: " + timenow.toString());
		System.out.println("Passenger name: "+name+"      Age: "+age);
		System.out.println("Travelling FROM: "+from+"     To: "+to);
		System.out.println("Boarding pass for seat number: " + seatNumber);
		System.out.println("This ticket is non-refundable and non-transferable.");
		System.out.println();
		System.out.println("ENJOY YOUR TRIP");
		System.out.println("****SAFE JOURNEY****");
		System.out.println();
	}
}