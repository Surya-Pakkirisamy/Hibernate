package hibernateController;

import java.util.Scanner;

import hibernateDAO.AddhaarDAO;
import hibernateDAO.PersonDAO;
import hibernateDTO.Addhaar;
import hibernateDTO.Person;

public class Task1 {

	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) 
	{
		PersonDAO personDao=new PersonDAO();
		AddhaarDAO addhaarDao=new AddhaarDAO();
	
//	get 2 addhaar and person and insert the data in database
	for(int i=0;i<2;i++)
	{
		Addhaar setAddhaar=addAddhaar();
		Person setPerson=addPerson(setAddhaar);		
        addhaarDao.insertAddhaar(setAddhaar);
		personDao.insertPerson(setPerson);
	}
		
//	delete one person addhaar detail and add new addhaar detail
		System.out.print("Enter the person id to get :");
		int person=scanner.nextInt();
		Person findedPerson = personDao.findPerson(person);
		Addhaar addhaar = findedPerson.getAddhaar();
		findedPerson.setAddhaar(null);
		Person updatedPerson = personDao.updatePerson(findedPerson, person);
		if(updatedPerson.getAddhaar() != null)
		{
		addhaarDao.deleteAddhaar(addhaar.getAddharNumber());
		}
		System.out.println(updatedPerson);	
		
		System.out.println("Enter the new Addhaar detail : ");
		Addhaar newAddhaar = addAddhaar();
		addhaarDao.insertAddhaar(newAddhaar);
		Person newFindedPerson = personDao.findPerson(person);
        newFindedPerson.setAddhaar(newAddhaar);
        personDao.updatePerson(newFindedPerson, person); 	
		
	}
	
	public static Addhaar addAddhaar()
	{
		Addhaar setAddhaar=new Addhaar();
		System.out.print("Enter the AddharPhNo : ");
		setAddhaar.setAddharPhNo(scanner.nextLong());
		System.out.print("Enter the Addhar Address : ");
		setAddhaar.setAddharAddress(scanner.next());
		return setAddhaar;
	}
	
	public static Person addPerson(Addhaar setAddhaar)
	{
		Person setPerson=new Person();
		System.out.print("Enter the Person Name : ");
		setPerson.setpName(scanner.next());
		System.out.print("Enter the Person Email : ");
		setPerson.setpEmail(scanner.next());
		setPerson.setAddhaar(setAddhaar);
		return setPerson;
	}

}
