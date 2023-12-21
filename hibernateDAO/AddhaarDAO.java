package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import hibernateDTO.Addhaar;

public class AddhaarDAO 
{
	public static Addhaar findAddhaar(int id)
	{
		EntityManager entityManager = DmlOperations.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Addhaar findedAddhaar = entityManager.find(Addhaar.class,id);
		transaction.commit();
		return findedAddhaar;
		
	}
	public Addhaar insertAddhaar(Addhaar addhaar)
	{
		EntityManager entityManager = DmlOperations.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		if(addhaar != null)
		{
		transaction.begin();
		entityManager.persist(addhaar);
		transaction.commit();
		}
		return addhaar;
	}
	
	
	public Addhaar deleteAddhaar(int id)
	{
		EntityManager entityManager = DmlOperations.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Addhaar findedAddhaar = entityManager.find(Addhaar.class, id);
		if(findedAddhaar != null)
		{
			transaction.begin();
			entityManager.remove(findedAddhaar);
			transaction.commit();
		}
		return findedAddhaar;
	}
	
	public Addhaar updateAddhaar(Addhaar addhaar)
	{
		EntityManager entityManager = DmlOperations.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Addhaar updateAddhaar = entityManager.find(Addhaar.class, addhaar.getAddharNumber());
		if(updateAddhaar != null)
		{
			transaction.begin();
			entityManager.merge(updateAddhaar);
			transaction.commit();
		}
		return updateAddhaar;
	}
}
