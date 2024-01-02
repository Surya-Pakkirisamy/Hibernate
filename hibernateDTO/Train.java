package hibernateDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Train 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainId;
	private String trainName;
	private int noOfCoches;
	private String start;
	private String destination;

	
	@Override
	public String toString() {
		return "Train [trainId=" + trainId + ", trainName=" + trainName + ", noOfCoches=" + noOfCoches + ", start="
				+ start + ", destination=" + destination + "]";
	}
	
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public int getNoOfCoches() {
		return noOfCoches;
	}
	public void setNoOfCoches(int noOfCoches) {
		this.noOfCoches = noOfCoches;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}
