package hibernateController;

import java.util.List;
import java.util.Scanner;

import hibernateDAO.CompanyDao;
import hibernateDAO.EmployeeDao;
import hibernateDTO.Company;
import hibernateDTO.Employee;

public class Task3 {

	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
//		Update all the employee salary to 5% whose company id = 1
		
//first get the all employee present in company id 1
		CompanyDao companyDao=new CompanyDao();
		System.out.print("Enter the Company Id : ");
		int companyId=scanner.nextInt();
		Company findedCompany = companyDao.findCompany(companyId);
		List<Employee> employees = findedCompany.getEmployees();		

//after completion of getting all employee update the all employee salary
		int size=employees.size();
		for(int i=0;i<size;i++)
		{
			Employee e=employees.get(i);
			e.setEmpSalary(e.getEmpSalary()+(e.getEmpSalary()*0.05));
			EmployeeDao employeeDao=new EmployeeDao();
			employeeDao.updateEmployee(e,e.getEmpId());			
		}		
		scanner.close();

	}

}
