/**
 * 
 */
package csci4380.finalpg.cars.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import csci4380.finalpg.cars.jpa.model.Car;

/**
 * @author berna
 *
 */
public interface CarRepository extends JpaRepository<Car, Integer> {

}
