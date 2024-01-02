package hibernateDTO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AddhaarBi 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addharNumber;
	private long addharPhNo;
	private String addharAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private PersonBi personBi;
	
	public int getAddharNumber() {
		return addharNumber;
	}
	public PersonBi getPersonBi() {
		return personBi;
	}
	public void setPersonBi(PersonBi personBi) {
		this.personBi = personBi;
	}
	public void setAddharNumber(int addharNumber) {
		this.addharNumber = addharNumber;
	}
	public long getAddharPhNo() {
		return addharPhNo;
	}
	public void setAddharPhNo(long addharPhNo) {
		this.addharPhNo = addharPhNo;
	}
	public String getAddharAddress() {
		return addharAddress;
	}
	public void setAddharAddress(String addharAddress) {
		this.addharAddress = addharAddress;
	}
	@Override
	public String toString() {
		return "AddhaarBi [addharNumber=" + addharNumber + ", addharPhNo=" + addharPhNo + ", addharAddress="
				+ addharAddress + "]";
	}

}
