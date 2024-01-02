package hibernateController;

import hibernateDAO.AddhaarDAO;
import hibernateDAO.PersonDAO;
import hibernateDTO.Addhaar;
import hibernateDTO.Person;

public class OneToOne 
{
	public static void main(String[] args) 
	{
		Addhaar  addhaar=new Addhaar();
		addhaar.setAddharPhNo(9003022960L);
		addhaar.setAddharAddress("51 T.K.M Road,Mamallapuram");
	
		AddhaarDAO insert=new AddhaarDAO();
		Addhaar insertAddhaar = insert.insertAddhaar(addhaar);
		System.out.println(insertAddhaar);
		
		Person person=new Person();
		person.setpName("Surya P");
		person.setpEmail("suriya15062001@gmail.com");
		person.setAddhaar(addhaar);
		
		PersonDAO insertPersonDAO=new PersonDAO();
		Person insertPerson = insertPersonDAO.insertPerson(person);
		System.out.println(insertPerson);
		
	}
}
