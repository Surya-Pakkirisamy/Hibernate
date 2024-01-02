package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.Passenger;

public class PassengerDao 
{
	EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
	EntityManager EntityManager = EntityManagerFactory.createEntityManager();
	EntityTransaction transaction = EntityManager.getTransaction();
	
	public Passenger findPassenger(int id)
	{
		Passenger findedPassenger = EntityManager.find(Passenger.class,id);
		return findedPassenger;	
	}
	public Passenger insertPassenger(Passenger Passenger)
	{		
		System.out.println("enter");
		transaction.begin();
		EntityManager.persist(Passenger);
		transaction.commit();
		return Passenger;
	}
	
	
	public Passenger deletePassenger(int id)
	{
		Passenger findedPassenger = findPassenger(id);
		if(findedPassenger != null)
		{
			transaction.begin();
			EntityManager.remove(findedPassenger);
			transaction.commit();
		}
		return findedPassenger;
	}
	
	public Passenger updatePassenger(Passenger Passenger,int id)
	{
		Passenger updatePassenger = findPassenger(id);
		if(updatePassenger != null)
		{
			Passenger.setPassengerId(id);
			transaction.begin();
			EntityManager.merge(Passenger);
			transaction.commit();
			return Passenger;
		}
		return updatePassenger;
	}
}
