package onetoOne;

import hibernateDAO.AddhaarDAO;
import hibernateDAO.PersonDAO;
import hibernateDTO.Person;

public class DeleteOneToOne {

	public static void main(String[] args) 
	{
		/*
		 * when i am trying to delete a entity present in another entity it is not
		 * possible because in the addhaar entity the primary key of addharId is acting
		 * as a forign key in the person entity that is the reason we cannot abble to delete it.
		 * for the above case below is the example code
		 */
	
//		AddhaarDAO deleteAddhar=new AddhaarDAO();
//		deleteAddhar.deleteAddhaar(222222222);
			
		/*
		 * if need to delete the entity .first remove the forign key of addhaarId
		 * present in person object and then remove the addhaar entity in this case it
		 * is possible to delete a entity.
		 */
		PersonDAO change=new PersonDAO();
		Person findedPerson = PersonDAO.findPerson(2);
		findedPerson.setAddhaar(null);
		Person updatePerson = change.updatePerson(findedPerson,findedPerson.getpId());
		System.out.println(updatePerson);
		AddhaarDAO deleteAddhar=new AddhaarDAO();
		deleteAddhar.deleteAddhaar(222222222);
		
		
		

	}

}
