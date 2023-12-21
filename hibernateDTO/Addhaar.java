package hibernateDTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Addhaar 
{
	@Id
	private int addharNumber;
	private long addharPhNo;
	private String addharAddress;
	
	public int getAddharNumber() {
		return addharNumber;
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
		return "Addhaar [addharNumber=" + addharNumber + ", addharPhNo=" + addharPhNo + ", addharAddress="
				+ addharAddress + "]";
	}
	
	
}
