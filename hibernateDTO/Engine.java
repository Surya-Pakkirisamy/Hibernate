package hibernateDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Engine 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int engineId;
	private int engineCC,noOfCylinder;
	public int getEngineId() {
		return engineId;
	}
	public void setEngineId(int engineId) {
		this.engineId = engineId;
	}
	public int getEngineCC() {
		return engineCC;
	}
	public void setEngineCC(int engineCC) {
		this.engineCC = engineCC;
	}
	public int getNoOfCylinder() {
		return noOfCylinder;
	}
	public void setNoOfCylinder(int noOfCylinder) {
		this.noOfCylinder = noOfCylinder;
	}
	@Override
	public String toString() {
		return "Engine [engineId=" + engineId + ", engineCC=" + engineCC + ", noOfCylinder=" + noOfCylinder + "]";
	}

	
	
}
