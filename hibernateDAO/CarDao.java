package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.Car;

public class CarDao 
{
	EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
	EntityManager EntityManager = EntityManagerFactory.createEntityManager();
	EntityTransaction transaction = EntityManager.getTransaction();
	
	public Car findCar(int id)
	{
		Car findedCar = EntityManager.find(Car.class,id);
		return findedCar;	
	}
	public Car insertCar(Car car)
	{
		Car findedCar = findCar(car.getCarId());
		if(findedCar == null)
		{
		transaction.begin();
		EntityManager.persist(car);
		transaction.commit();
		}
		return null;
	}
	
	
	public Car deleteCar(int id)
	{
		Car findedCar = findCar(id);
		if(findedCar != null)
		{
			transaction.begin();
			EntityManager.remove(findedCar);
			transaction.commit();
		}
		return findedCar;
	}
	
	public Car updateCar(Car car,int id)
	{
		Car updateCar = findCar(id);
		if(updateCar != null)
		{
			car.setCarId(id);
			transaction.begin();
			EntityManager.merge(car);
			transaction.commit();
			return car;
		}
		return updateCar;
	}
}
