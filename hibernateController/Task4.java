package hibernateController;

import java.util.ArrayList;
import java.util.List;

import hibernateDAO.CompanyDao;
import hibernateDAO.EmployeeDao;
import hibernateDTO.Company;
import hibernateDTO.Employee;

public class Task4 
{
	public static void main(String[] args) 
	{
		/* Delete an employee whose Name is suresh j present in Company id =1 */
		
		CompanyDao company=new CompanyDao();
		Company findedCompany = company.findCompany(1);
		List<Employee> employees = findedCompany.getEmployees();
		List<Integer> employeesid=new ArrayList<Integer>();
		
		for(int i=0;i<employees.size();i++)
		{
			Employee e=employees.get(i);
			if(e.getEmpName().equals("Mani"))
			{
				employeesid.add(e.getEmpId());
				employees.remove(i);	
				i--;
			}
		}
		
		findedCompany.setEmployees(employees);	
		company.updateCompany(findedCompany, 1);	

		EmployeeDao employeeDao=new EmployeeDao();
		for(int j:employeesid)
		{
			employeeDao.deleteEmployee(j);
		}		
	}
}
