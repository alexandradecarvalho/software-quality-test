## Software Quality And Tests

### Lab 04: Multi-layer application testing



#### Ex1 - Study the example available concerning a simplified [Employee management application](https://gitlab.com/ico_gl/ua_tqs_gs20/-/tree/master/gs-employee-mngr) (gs-employee-manager)



##### a) Identify a couple of examtestples on the use of AssertJ expressive methods chaining.

AssertJ allows concise code by allowing chaining multiple assertions into a single line, such as:

```java
@Test
public void givenSetOfEmployees_whenFindAll_thenReturnAllEmployees() {
    ...
    assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(
        alex.getName(), ron.getName(), bob.getName());
}
```

```java
@Test
public void given3Employees_whengetAll_thenReturn3Records() {
    ...
	assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(
        alex.getName(), john.getName(), bob.getName());
}
```

```java
@Test
public void whenValidInput_thenCreateEmployee() throws IOException, Exception {
    ...		
    assertThat(found).extracting(Employee::getName).containsOnly("bob");
}
```

```java
@Test
public void givenEmployees_whenGetEmployees_thenStatus200()  {
    ...
    assertThat(response.getBody()).extracting(Employee::getName).containsExactly("bob", "alex");

}
```



##### b) Identify an example in which you mock the behavior of the repository (and avoid involving a
database).

In test B, which verifies the business logic associated with the services implementation, the repository can be mocked to make it a unit test (much faster):

```java
@Mock( lenient = true)
private EmployeeRepository employeeRepository;
```

 

##### c) What is the difference between standard @Mock and @MockBean?

@Mock annotation is the same as the *Mockito.mock()* method, so it requires that the Mockito annotations are enabled. It is only used in test classes. @Mock makes it easier to find the problem in case of a failure and makes the code more readable. Also, when used in conjunction with *@InjectMocks*, it can reduce the amount of setup code significantly.

@MockBean annotation adds mock objects to the Spring application context, and there it replaces any existing bean of the same type, or adds a new one if there is no bean of that type. This annotation is useful in integration tests where a particular bean needs to be mocked.

**Source**[](https://www.baeldung.com/java-spring-mockito-mock-mockbean)



##### d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

This file assures the correct properties are set to set up the expected integration test environment. In the case of this project, the file has informations of the integrated component: the database, including its url, username and password. 





