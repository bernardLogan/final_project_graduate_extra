/**
 * 
 */
package csci4380.finalpg.cars.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author berna
 *
 */
@Entity(name="CAR")
public class Car {
@Id
@GeneratedValue
private Integer carId;
private String  brandName;
private String  model;
private String  year;
private Integer price;
private Boolean isInsured;


public Car() {
}


public Car(String brandName, String model, String year, Integer price, Boolean isInsured) {
	this.brandName = brandName;
	this.model = model;
	this.year = year;
	this.price = price;
	this.isInsured = isInsured;
}


public Car(Integer carId, String brandName, String model, String year, Integer price, Boolean isInsured) {
	this(brandName, model, year, price, isInsured);
	this.carId = carId;
	
}


public Integer getCarId() {
	return carId;
}


public void setCarId(Integer carId) {
	this.carId = carId;
}


public String getBrandName() {
	return brandName;
}


public void setBrandName(String brandName) {
	this.brandName = brandName;
}


public String getModel() {
	return model;
}


public void setModel(String model) {
	this.model = model;
}


public String getYear() {
	return year;
}


public void setYear(String year) {
	this.year = year;
}


public Integer getPrice() {
	return price;
}


public void setPrice(Integer price) {
	this.price = price;
}


public Boolean getIsInsured() {
	return isInsured;
}


public void setIsInsured(Boolean isInsured) {
	this.isInsured = isInsured;
}





}
