package tqs.lab4.ex2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long>{
    Car findByCarId(Long id);
    List<Car> findAll();
}
