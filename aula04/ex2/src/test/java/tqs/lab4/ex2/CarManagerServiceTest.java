package tqs.lab4.ex2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.internal.verification.VerificationModeFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CarManagerServiceTest {

    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService carManagerService;

    @BeforeEach
    void setUp() {
        Car my_car1 = new Car("Porsche", "Cayenne");
        my_car1.setCarId(1);

        Car my_car2 = new Car("Tesla", "Model S");
        my_car2.setCarId(2);

        Car my_car3 = new Car("Dacia", "Duster");

        List<Car> allCars = Arrays.asList(my_car1,my_car2,my_car3);

        Mockito.when(carRepository.findByCarId(my_car1.getCarId())).thenReturn(my_car1);
        Mockito.when(carRepository.findByCarId(Long.valueOf(4))).thenReturn(null);
        Mockito.when(carRepository.findById(Long.valueOf(5))).thenReturn(Optional.empty());
        Mockito.when(carRepository.findAll()).thenReturn(allCars);
    }

    @Test
    void getValidCarDetails() {
        Long id = Long.valueOf(1);
        Car found = carManagerService.getCarDetails(id);
        assertThat(found.getCarId()).isEqualTo(id);
    }

    @Test
    public void getInvalidCarDetails() {
        Car found = carManagerService.getCarDetails(Long.valueOf(4));
        assertThat(found).isNull();

        verifyFindByCarIdIsCalledOnce(Long.valueOf(4));
    }

    @Test
    public void ValidIdCarIsFound(){
        Car found = carManagerService.getCarDetails(Long.valueOf(1));
        assertThat(found.getMaker()).isEqualTo("Porsche");

        verifyFindByCarIdIsCalledOnce();
    }

    @Test
    public void InvalidIdCarIsNotFound(){
        Car found = carManagerService.getCarDetails(Long.valueOf(5));
        assertThat(found).isNull();

        verifyFindByCarIdIsCalledOnce();
    }

    @Test
    public void getAllRecords(){
        Car my_car1 = new Car("Porsche", "Cayenne");
        Car my_car2 = new Car("Tesla", "Model S");
        Car my_car3 = new Car("Dacia", "Duster");

        List<Car> allCars = carManagerService.getAllCars();
        verifyFindAllCarsIsCalledOnce();
        assertThat(allCars).hasSize(3).extracting(Car::getModel).contains(my_car1.getModel(), my_car2.getModel(), my_car3.getModel());

    }


    private void verifyFindByCarIdIsCalledOnce(Long id) {
        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findByCarId(id);
    }
    private void verifyFindByCarIdIsCalledOnce() {
        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findByCarId(Mockito.anyLong());
    }
    private void verifyFindAllCarsIsCalledOnce() {
        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findAll();
    }
}