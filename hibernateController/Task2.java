package hibernateController;

import java.util.Scanner;

import hibernateDAO.CarDao;
import hibernateDAO.EngineDao;
import hibernateDTO.Car;
import hibernateDTO.Engine;

public class Task2 {

	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
//		get 3 car and Engine and insert the data in database
		for(int i=0;i<3;i++)
		{
			Engine setEngine=new Engine();
			System.out.print("Enter the Engine CC :");
			setEngine.setEngineCC(scanner.nextInt());
			System.out.print("Enter the No of Cylinder :");
			setEngine.setNoOfCylinder(scanner.nextInt());
			
			Car setCar=new Car();
			System.out.print("Enter the Car Brand :");
			setCar.setCarBrand(scanner.next());
			System.out.print("Enter the Car Name :");
			setCar.setCarName(scanner.next());
			setCar.setEngine(setEngine);
			
			CarDao sendCar=new CarDao();
			EngineDao deleteEngine=new EngineDao();
	        deleteEngine.insertEngine(setEngine);
			sendCar.insertCar(setCar);
		}
		
//	get the car id 3 and update the car engine cc
		
		CarDao getCar=new CarDao();
		System.out.print("Enter the car no to get :");
		int carNo=scanner.nextInt();
		Car findedCar = getCar.findCar(carNo);
		Engine engine = findedCar.getEngine();
		System.out.print("Enter the CC :");
		engine.setEngineCC(scanner.nextInt());
		findedCar.setEngine(engine);
		Car updateCar = getCar.updateCar(findedCar, carNo);
		System.out.println(updateCar);
		
		System.out.println("Updated succesfully");
		scanner.close();
	}

}
