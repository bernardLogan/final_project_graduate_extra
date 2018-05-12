/**
 * 
 */
package csci4380.finalpg.cars.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import csci4380.finalpg.cars.jpa.model.Car;
import csci4380.finalpg.cars.jpa.repo.CarRepository;

/**
 * @author berna
 *
 */
@RestController
@RequestMapping("rest/v1/cars")
public class CarRestController {
@Autowired CarRepository carRepository;

@RequestMapping("/echoMessage")
@ResponseBody
public String echoMessage(@RequestParam(value="msg", defaultValue=" Hi Bernard Logan!") String message) {
	return "echoMessage echoes: " + message;
}

@GetMapping
public Page<Car> findAll(@RequestParam(defaultValue="0") int page, @RequestParam(value="rowsPerPage", defaultValue="3") int size) {
	Page<Car> carsPage = carRepository.findAll(new PageRequest(page, size));
	return carsPage;
}

@GetMapping("/all")
public List <Car> findAll(){
	List <Car> cars = carRepository.findAll();
	return cars;
}

@PostMapping("")
public  Optional<Car> save(@RequestBody final Car car) {
	Car savedCar = carRepository.save(car);
	return carRepository.findById(savedCar.getCarId());
}

@DeleteMapping("/carId/{carId}")
public void deleteById(@PathVariable Integer carId)
{
	carRepository.deleteById(carId);
}

@PutMapping("/carId/{carId}")
public ResponseEntity<Object> update(@RequestBody Car car, Integer carId)
{
	Optional<Car> catOptional = carRepository.findById(carId);

	car.setCarId(carId);
	carRepository.save(car);
	return ResponseEntity.noContent().build();
	
}

}
