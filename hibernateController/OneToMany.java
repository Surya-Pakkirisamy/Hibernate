package hibernateController;

import java.util.ArrayList;
import java.util.List;

import hibernateDAO.CompanyDao;
import hibernateDTO.Company;
import hibernateDTO.Employee;

public class OneToMany {

	public static void main(String[] args) 
	{
		Employee employee1=new Employee();
		employee1.setEmpName("Surya P");
		employee1.setEmpEmail("suriay@gmail.com");
		employee1.setEmpContact(9003022960l);
		employee1.setEmpSalary(400000);
		
		Employee employee2=new Employee();
		employee2.setEmpName("Mani");
		employee2.setEmpEmail("mani@gmail.com");
		employee2.setEmpContact(9003022960l);
		employee2.setEmpSalary(800000);
		
		Employee employee3=new Employee();
		employee3.setEmpName("Suresh J");
		employee3.setEmpEmail("suresh@gmail.com");
		employee3.setEmpContact(9003022960l);
		employee3.setEmpSalary(600000);
		
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		
		Company company=new Company();
		company.setCompanyName("Zoho");
		company.setCompanyAddress("Guduvanjerry");
		company.setEmployees(employees);
		
		/*
		 * There is no need to insert the employees into the table if
		 * (cascade=CascadeType.ALL) written in the OnetoMany annotation It will
		 * Automatically insert the employee.
		 */

		/*
		 * setEmployee.insertEmployee(employee1); 
		 * setEmployee.insertEmployee(employee2);
		 * setEmployee.insertEmployee(employee3);
		 */
		
		CompanyDao addCompany=new CompanyDao();
		addCompany.insertCompany(company);
	}

}
