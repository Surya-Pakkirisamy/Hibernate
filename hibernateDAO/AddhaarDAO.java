package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.Addhaar;

public class AddhaarDAO 
{
	EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
	EntityManager EntityManager = EntityManagerFactory.createEntityManager();
	EntityTransaction transaction = EntityManager.getTransaction();
	
	public Addhaar findAddhaar(int id)
	{
		transaction.begin();
		Addhaar findedAddhaar = EntityManager.find(Addhaar.class,id);
		transaction.commit();
		return findedAddhaar;
		
	}
	public Addhaar insertAddhaar(Addhaar addhaar)
	{
		if(addhaar != null)
		{
		transaction.begin();
		EntityManager.persist(addhaar);
		transaction.commit();
		}
		return addhaar;
	}
	
	
	public Addhaar deleteAddhaar(int id)
	{
		Addhaar findedAddhaar = findAddhaar(id);
		if(findedAddhaar != null)
		{
			transaction.begin();
			EntityManager.remove(findedAddhaar);
			transaction.commit();
		}
		return findedAddhaar;
	}
	
	public Addhaar updateAddhaar(Addhaar addhaar,int id)
	{
		Addhaar updateAddhaar = findAddhaar(id);
		if(updateAddhaar != null)
		{
			addhaar.setAddharNumber(id);
			transaction.begin();
			EntityManager.merge(addhaar);
			transaction.commit();
			return addhaar;
		}
		return updateAddhaar;
	}
}
