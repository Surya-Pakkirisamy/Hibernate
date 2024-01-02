package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.PersonBi;

public class PersonDaoBiDirection 
{
	EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
	EntityManager EntityManager = EntityManagerFactory.createEntityManager();
	EntityTransaction transaction = EntityManager.getTransaction();
	
	public PersonBi findPersonBi(int id)
	{
		transaction.begin();
		PersonBi findedPersonBi = EntityManager.find(PersonBi.class,id);
		transaction.commit();
		return findedPersonBi;
		
	}
	public PersonBi insertPersonBi(PersonBi PersonBi)
	{
		if(PersonBi != null)
		{
		transaction.begin();
		EntityManager.persist(PersonBi);
		transaction.commit();
		}
		return PersonBi;
	}
	
	
	public PersonBi deletePersonBi(int id)
	{
		PersonBi findedPersonBi = findPersonBi(id);
		if(findedPersonBi != null)
		{
			transaction.begin();
			EntityManager.remove(findedPersonBi);
			transaction.commit();
		}
		return findedPersonBi;
	}
	
	public PersonBi updatePersonBi(PersonBi PersonBi,int id)
	{
		PersonBi updatePersonBi = findPersonBi(id);
		if(updatePersonBi != null)
		{
			PersonBi.setpId(id);
			transaction.begin();
			EntityManager.merge(PersonBi);
			transaction.commit();
			return PersonBi;
		}
		return updatePersonBi;
	}
}
