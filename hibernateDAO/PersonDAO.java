package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.Person;

public class PersonDAO 
{
	
	EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
	EntityManager EntityManager = EntityManagerFactory.createEntityManager();
	EntityTransaction transaction = EntityManager.getTransaction();
	
	public Person findPerson(int id)
	{
		transaction.begin();
		Person findedPerson = EntityManager.find(Person.class,id);
		transaction.commit();
		return findedPerson;
		
	}
	public Person insertPerson(Person Person)
	{
		if(Person != null)
		{
		transaction.begin();
		EntityManager.persist(Person);
		transaction.commit();
		}
		return Person;
	}
	
	
	public Person deletePerson(int id)
	{
		Person findedPerson = findPerson(id);
		if(findedPerson != null)
		{
			transaction.begin();
			EntityManager.remove(findedPerson);
			transaction.commit();
		}
		return findedPerson;
	}
	
	public Person updatePerson(Person Person,int id)
	{
		Person updatePerson = findPerson(id);
		if(updatePerson != null)
		{
			Person.setpId(id);
			transaction.begin();
			EntityManager.merge(Person);
			transaction.commit();
			return Person;
		}
		return updatePerson;
	}
}
