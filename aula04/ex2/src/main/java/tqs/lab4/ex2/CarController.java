package tqs.lab4.ex2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    private CarManagerService carManagerService;

    public CarController(CarManagerService carManagerService){
        this.carManagerService = carManagerService;
    }

    @PostMapping("/cars" )
    public ResponseEntity<Car> createCar(@RequestBody Car new_car){
        System.out.println(new_car);
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carManagerService.save(new_car);
        return new ResponseEntity<>(saved,status);
    }

    @GetMapping(path="/cars")
    public List<Car> getAllCars(){
        return carManagerService.getAllCars();
    }

    @GetMapping(path="/cars/{id}")
    public Car getCarById(@PathVariable Long id){
        return carManagerService.getCarDetails(id);
    }
}
