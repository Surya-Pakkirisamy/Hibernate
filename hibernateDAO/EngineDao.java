package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.Engine;

public class EngineDao 
{
	EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
	EntityManager EntityManager = EntityManagerFactory.createEntityManager();
	EntityTransaction transaction = EntityManager.getTransaction();
	
	public Engine findEngine(int id)
	{
		Engine findedEngine = EntityManager.find(Engine.class,id);
		return findedEngine;	
	}
	public Engine insertEngine(Engine Engine)
	{
		Engine findedEngine = findEngine(Engine.getEngineId());
		if(findedEngine == null)
		{
		transaction.begin();
		EntityManager.persist(Engine);
		transaction.commit();
		}
		return null;
	}
	
	
	public Engine deleteEngine(int id)
	{
		Engine findedEngine = findEngine(id);
		if(findedEngine != null)
		{
			transaction.begin();
			EntityManager.remove(findedEngine);
			transaction.commit();
		}
		return findedEngine;
	}
	
	public Engine updateEngine(Engine Engine,int id)
	{
		Engine updateEngine = findEngine(id);
		if(updateEngine != null)
		{
			Engine.setEngineId(id);
			transaction.begin();
			EntityManager.merge(Engine);
			transaction.commit();
			return Engine;
		}
		return updateEngine;
	}
}
