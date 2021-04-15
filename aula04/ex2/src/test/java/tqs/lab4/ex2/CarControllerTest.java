package tqs.lab4.ex2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;


@WebMvcTest(CarController.class)
public class CarControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService service;

    @Test
    public void givenACar_createsCar() throws Exception {
        Car my_car = new Car("Porsche", "Cayenne");

        when(service.save(Mockito.any())).thenReturn(my_car);

        mvc.perform(post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(my_car)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.model", is("Cayenne")));

        verify(service, times(1)).save(Mockito.any());
    }

    @Test
    public void getsAllCars() throws Exception {
        Car my_car1 = new Car("Tesla", "Model S");
        Car my_car2 = new Car("Mini", "Cooper");
        Car my_car3 = new Car("Porsche", "Cayenne");

        List<Car> allCars = Arrays.asList(my_car1, my_car2, my_car3);

        given(service.getAllCars()).willReturn(allCars);

        mvc.perform(get("/api/cars").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[0].model", is(my_car1.getModel()))).andExpect(jsonPath("$[1].model", is(my_car2.getModel())))
                .andExpect(jsonPath("$[2].model", is(my_car3.getModel())));
        verify(service, VerificationModeFactory.times(1)).getAllCars();

    }

}
