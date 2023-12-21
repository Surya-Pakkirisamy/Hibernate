package student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.Student;

public class Delete 
{
 public static void main(String[] args) {
	EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
	EntityManager EntityManager = EntityManagerFactory.createEntityManager();
	EntityTransaction transaction = EntityManager.getTransaction();
	
	Student find = EntityManager.find(Student.class, 1);
	/*
	 * transaction.begin(); 
	 * EntityManager.remove(find); 
	 * transaction.commit();
	 */
	System.out.println(find);
}
}
             	