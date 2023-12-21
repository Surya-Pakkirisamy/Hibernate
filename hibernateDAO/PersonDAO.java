package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import hibernateDTO.Person;

public class PersonDAO 
{
	public static Person findPerson(int id)
	{
		EntityManager entityManager = DmlOperations.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Person findedPerson = entityManager.find(Person.class,id);
		transaction.commit();
		return findedPerson;
		
	}
	public Person insertPerson(Person person)
	{
		EntityManager entityManager = DmlOperations.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		if(person != null)
		{
		transaction.begin();
		entityManager.persist(person);
		transaction.commit();
		}
		return person;
	}
	
	
	public Person deletePerson(int id)
	{
		EntityManager entityManager = DmlOperations.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Person findedPerson = entityManager.find(Person.class, id);
		if(findedPerson != null)
		{
			transaction.begin();
			entityManager.remove(findedPerson);
			transaction.commit();
		}
		return findedPerson;
	}
	
	public Person updatePerson(Person person)
	{
		EntityManager entityManager = DmlOperations.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Person updatePerson = entityManager.find(Person.class, person.getpId());
		if(updatePerson != null)
		{
			transaction.begin();
			entityManager.merge(updatePerson);
			transaction.commit();
		}
		return updatePerson;
	}

}
