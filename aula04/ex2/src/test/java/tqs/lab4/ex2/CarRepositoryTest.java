package tqs.lab4.ex2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    void findValidByCarId() {
        Car my_car = new Car("Tesla", "Model S");
        entityManager.persistAndFlush(my_car); //ensure data is persisted at this point

        Car found = carRepository.findByCarId(my_car.getCarId());
        assertThat(found).isEqualTo(my_car);
    }

    @Test
    void findInvalidByCarId(){
        Car found = carRepository.findByCarId(Long.valueOf(7));
        assertThat(found).isNull();
    }

    @Test
    void findAll() {
        Car my_car1 = new Car("Tesla", "Model S");
        Car my_car2 = new Car("Porsche", "Cayenne");
        Car my_car3 = new Car("Dacia", "Duster");

        entityManager.persist(my_car1);
        entityManager.persist(my_car2);
        entityManager.persist(my_car3);
        entityManager.flush();

        List<Car> allCars = carRepository.findAll();

        assertThat(allCars).hasSize(3).extracting(Car::getModel).containsOnly(my_car1.getModel(), my_car2.getModel(), my_car3.getModel());

    }
}