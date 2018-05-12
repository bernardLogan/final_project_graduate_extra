/**
 * 
 */
package csci4380.finalpg.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import csci4380.finalpg.cars.jpa.model.Car;
import csci4380.finalpg.cars.jpa.repo.CarRepository;

/**
 * @author berna
 *
 */
@Component
public class InitCarDb implements CommandLineRunner {
private CarRepository carRepository;


    @Autowired
	public InitCarDb(CarRepository carRepository) {
	this.carRepository = carRepository;
}



	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		Car car1 = new Car("Honda", "Civic", "1997", 2000, true);
		Car saved1car = carRepository.save(car1);
		System.out.println("-----> BERNARD ----> Saved car1");

	}

}
