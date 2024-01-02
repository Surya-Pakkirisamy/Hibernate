package hibernateDTO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PersonBi 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
	private String pName,pEmail;
	@OneToOne(cascade = CascadeType.ALL)
	private AddhaarBi addhaar;
	
	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pName=" + pName + ", pEmailString=" + pEmail + ", addhaar=" + addhaar
				+ "]";
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpEmail() {
		return pEmail;
	}
	public void setpEmail(String pEmail) {
		this.pEmail = pEmail;
	}
	public AddhaarBi getAddhaar() {
		return addhaar;
	}
	public void setAddhaar(AddhaarBi addhaar) {
		this.addhaar = addhaar;
	}
	
	

}
