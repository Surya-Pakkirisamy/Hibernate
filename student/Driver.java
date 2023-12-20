package student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import HibernateDTO.Student;

public class Driver {

	public static void main(String[] args) 
	{
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("surya");
		EntityManager createEntityManager = createEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = createEntityManager.getTransaction();
		Student s1=new Student();
		s1.setId(2);
		s1.setPercentage(97);
		s1.setPhno("9003022960");			
		s1.setName("surya");
		transaction.begin();
		createEntityManager.persist(s1);
		transaction.commit();
	}

}
