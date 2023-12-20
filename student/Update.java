package student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import HibernateDTO.Student;

public class Update {

	public static void main(String[] args) 
	{
		
		EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
		EntityManager EntityManager = EntityManagerFactory.createEntityManager();
		EntityTransaction transaction = EntityManager.getTransaction();
		
		Student oldstd =EntityManager.find(Student.class, 1);
		System.out.println(oldstd);
		
		oldstd.setName("surya Pa");
		oldstd.setPhno("7200291704");
//		merge will acts as both update and insert
//		this update
		transaction.begin();
		Student newstd = EntityManager.merge(oldstd);
		transaction.commit();
		System.out.println(newstd);
		
//		this is insert using merge
		Student s1=new Student();
		s1.setId(2);
		s1.setName("mani");
		s1.setPercentage(95);
		s1.setPhno("9003022960");
		transaction.begin();
		Student insertedstd = EntityManager.merge(s1);
		System.out.println(insertedstd);
	}

}
