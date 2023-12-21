package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.Student;

public class DmlOperations 
{
	public static  EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("surya").createEntityManager();
	}
	
	public Student insert(Student s)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction eTransaction=entityManager.getTransaction();
		eTransaction.begin();
		entityManager.persist(s);
		eTransaction.commit();
		return s;
	}
	
	public void delete(int id)
	{
		
	}
}
