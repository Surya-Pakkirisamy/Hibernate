package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.AddhaarBi;

public class AddhaarDaoBiDirection 
{
	EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
	EntityManager EntityManager = EntityManagerFactory.createEntityManager();
	EntityTransaction transaction = EntityManager.getTransaction();
	
	public AddhaarBi findAddhaarBi(int id)
	{
		transaction.begin();
		AddhaarBi findedAddhaarBi = EntityManager.find(AddhaarBi.class,id);
		transaction.commit();
		return findedAddhaarBi;
		
	}
	public AddhaarBi insertAddhaarBi(AddhaarBi AddhaarBi)
	{
		if(AddhaarBi != null)
		{
		transaction.begin();
		EntityManager.persist(AddhaarBi);
		transaction.commit();
		}
		return AddhaarBi;
	}
	
	
	public AddhaarBi deleteAddhaarBi(int id)
	{
		AddhaarBi findedAddhaarBi = findAddhaarBi(id);
		if(findedAddhaarBi != null)
		{
			transaction.begin();
			EntityManager.remove(findedAddhaarBi);
			transaction.commit();
		}
		return findedAddhaarBi;
	}
	
	public AddhaarBi updateAddhaarBi(AddhaarBi AddhaarBi,int id)
	{
		AddhaarBi updateAddhaarBi = findAddhaarBi(id);
		if(updateAddhaarBi != null)
		{
			AddhaarBi.setAddharNumber(id);
			transaction.begin();
			EntityManager.merge(AddhaarBi);
			transaction.commit();
			return AddhaarBi;
		}
		return updateAddhaarBi;
	}
}
