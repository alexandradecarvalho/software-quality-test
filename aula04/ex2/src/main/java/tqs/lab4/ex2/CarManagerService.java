package tqs.lab4.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarManagerService {

    @Autowired
    private CarRepository carRepository;

    public Car save(Car new_car){
        return carRepository.save(new_car);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car getCarDetails(Long id){
        return carRepository.findByCarId(id);
    }

}
