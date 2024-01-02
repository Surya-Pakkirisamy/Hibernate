package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.Employee;

public class EmployeeDao 
{
	EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
	EntityManager EntityManager = EntityManagerFactory.createEntityManager();
	EntityTransaction transaction = EntityManager.getTransaction();
	
	public Employee findEmployee(int id)
	{
		Employee findedEmployee = EntityManager.find(Employee.class,id);
		return findedEmployee;	
	}
	public Employee insertEmployee(Employee Employee)
	{
		Employee findedEmployee = findEmployee(Employee.getEmpId());
		if(findedEmployee == null)
		{
		transaction.begin();
		EntityManager.persist(Employee);
		transaction.commit();
		}
		return null;
	}
	
	
	public Employee deleteEmployee(int id)
	{
		Employee findedEmployee = findEmployee(id);
		if(findedEmployee != null)
		{
			transaction.begin();
			EntityManager.remove(findedEmployee);
			transaction.commit();
		}
		return findedEmployee;
	}
	
	public Employee updateEmployee(Employee Employee,int id)
	{
		Employee updateEmployee = findEmployee(id);
		if(updateEmployee != null)
		{
			Employee.setEmpId(id);
			transaction.begin();
			EntityManager.merge(Employee);
			transaction.commit();
			return Employee;
		}
		return updateEmployee;
	}

}
