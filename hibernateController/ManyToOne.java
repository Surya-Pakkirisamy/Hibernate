package hibernateController;

import java.util.Scanner;

import hibernateDAO.PassengerDao;
import hibernateDTO.Passenger;
import hibernateDTO.Train;

public class ManyToOne {

	static Scanner scanner=new Scanner(System.in); 
	public static void main(String[] args) 
	{
		PassengerDao passengerDao=new PassengerDao();
		
		Train train=new Train();
		train.setTrainName("bharat Express"); 
		train.setNoOfCoches(12);
		train.setStart("Chennai"); 
		train.setDestination("Tirupathi");
		
		System.out.print("Enter the no of passengers : "); 
		int passengers=scanner.nextInt();
		for(int i=0;i<passengers;i++)
		{
			Passenger addPasenger = addPasenger();
			addPasenger.setTrain(train);
			passengerDao.insertPassenger(addPasenger);
		}

		scanner.close();
	}
	
	public static Passenger addPasenger()
	{
		
		
		Passenger passenger=new Passenger();

		System.out.print("Enter Passenger Name :");
		passenger.setPassengerName(scanner.next());
		passenger.setPassengerEmail("surya@gmail.com");
		passenger.setPassengerContact(9003022960l); 
		  
		  
		  return passenger;
		
	}
	

}
