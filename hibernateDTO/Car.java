package hibernateDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carId;
	private String carBrand;
	private String carName;
	@OneToOne
	private Engine engine;
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carBrand=" + carBrand + ", carName=" + carName + ", engine=" + engine + "]";
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
	
	
	
}
