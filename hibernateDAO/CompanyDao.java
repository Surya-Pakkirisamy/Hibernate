package hibernateDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateDTO.Company;

public class CompanyDao 
{
	EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("surya");
	EntityManager EntityManager = EntityManagerFactory.createEntityManager();
	EntityTransaction transaction = EntityManager.getTransaction();
	
	public Company findCompany(int id)
	{
		Company findedCompany = EntityManager.find(Company.class,id);
		return findedCompany;	
	}
	public Company insertCompany(Company Company)
	{
		Company findedCompany = findCompany(Company.getCompanyId());
		if(findedCompany == null)
		{
		transaction.begin();
		EntityManager.persist(Company);
		transaction.commit();
		}
		return null;
	}
	
	
	public Company deleteCompany(int id)
	{
		Company findedCompany = findCompany(id);
		if(findedCompany != null)
		{
			transaction.begin();
			EntityManager.remove(findedCompany);
			transaction.commit();
		}
		return findedCompany;
	}
	
	public Company updateCompany(Company Company,int id)
	{
		Company updateCompany = findCompany(id);
		if(updateCompany != null)
		{
			Company.setCompanyId(id);
			transaction.begin();
			EntityManager.merge(Company);
			transaction.commit();
			return Company;
		}
		return updateCompany;
	}
}
