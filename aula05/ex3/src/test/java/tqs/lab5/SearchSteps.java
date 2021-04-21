package tqs.lab5;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class SearchSteps {
    private WebDriver webDriver;

    @When("I navigate to {string}")
    public void iNavigateTo(String url){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get(url);
    }

    @And("I select from {string}")
    public void iSelectFrom(String fromQuery){
        WebElement dropdown = webDriver.findElement(By.name("fromPort"));
        dropdown.findElement(By.xpath("//option[. = '" + fromQuery + "']")).click();

        Actions builder = new Actions(webDriver);
        builder.moveToElement(dropdown).clickAndHold().perform();
        builder.moveToElement(dropdown).perform();
        builder.moveToElement(dropdown).release().perform();
    }

    @And("I select to {string}")
    public void iSelectTo(String toQuery){
        WebElement dropdown = webDriver.findElement(By.name("toPort"));
        dropdown.findElement(By.xpath("//option[. = '" + toQuery + "']")).click();

        Actions builder = new Actions(webDriver);
        builder.moveToElement(dropdown).clickAndHold().perform();
        builder.moveToElement(dropdown).perform();
        builder.moveToElement(dropdown).release().perform();
    }

    @And("I fill in my name with {string}")
    public void iFillNameWith(String name){
        webDriver.findElement(By.cssSelector(".btn-primary")).click();
        webDriver.findElement(By.cssSelector("tr:nth-child(5) .btn")).click();
        webDriver.findElement(By.id("inputName")).click();
        webDriver.findElement(By.id("inputName")).sendKeys(name);
    }

    @And("I fill in my address with {string}")
    public void iFillAddressWith(String address){
        webDriver.findElement(By.id("address")).sendKeys(address);
    }

    @And("I fill in my city with {string}")
    public void iFillCityWith(String city){
        webDriver.findElement(By.id("city")).sendKeys(city);
    }

    @And("I fill in my state with {string}")
    public void iFillStateWith(String state){
        webDriver.findElement(By.id("state")).sendKeys(state);
    }

    @And("I fill in my zip code with {string}")
    public void iFillCodeWith(String zipcode){
        webDriver.findElement(By.id("zipCode")).sendKeys(zipcode);
    }

    @And("I fill in my credit card number with {string}")
    public void iFillCCNumberWith(String ccnumber){
        WebElement element = webDriver.findElement(By.id("cardType"));
        Actions builder = new Actions(webDriver);

        builder.moveToElement(element).clickAndHold().perform();
        builder.moveToElement(element).perform();
        builder.moveToElement(element).release().perform();
        webDriver.findElement(By.id("creditCardNumber")).click();
        webDriver.findElement(By.id("creditCardNumber")).sendKeys(ccnumber);
    }

    @And("I fill in my credit card month with {string}")
    public void iFillCCMonthWith(String ccmonth){
        webDriver.findElement(By.id("creditCardMonth")).click();
        webDriver.findElement(By.id("creditCardMonth")).sendKeys(ccmonth);
    }

    @And("I fill in my credit card year with {string}")
    public void iFillCCYearWith(String ccyear){
        webDriver.findElement(By.id("creditCardMonth")).click();
        webDriver.findElement(By.id("creditCardMonth")).sendKeys(ccyear);
    }

    @And("I fill in my credit card name with {string}")
    public void iFillCCNameWith(String ccname){
        webDriver.findElement(By.id("nameOnCard")).click();
        webDriver.findElement(By.id("nameOnCard")).sendKeys(ccname);
    }

    @Then("I should be {string} from {string}, {string}, {string} at {string} with {string}'s credit card {string} until {string} of {string}")
    public void iShouldBe(String name, String address, String city, String state, String zipCode, String ccName, String ccNumber, String ccMonth, String ccYear){
        String value = webDriver.findElement(By.id("inputName")).getAttribute("value");
        assertThat(value, is(name));

        value = webDriver.findElement(By.id("address")).getAttribute("value");
        assertThat(value, is(address));

        value = webDriver.findElement(By.id("city")).getAttribute("value");
        assertThat(value, is(city));

        value = webDriver.findElement(By.id("state")).getAttribute("value");
        assertThat(value, is(state));

        value = webDriver.findElement(By.id("zipCode")).getAttribute("value");
        assertThat(value, is(zipCode));

        value = webDriver.findElement(By.id("cardType")).getAttribute("value");
        assertThat(value, is("visa"));

        value = webDriver.findElement(By.id("creditCardNumber")).getAttribute("value");
        assertThat(value, is(ccNumber));

        value = webDriver.findElement(By.id("creditCardMonth")).getAttribute("value");
        assertThat(value, is("11"+ccMonth+"2017"));

        value = webDriver.findElement(By.id("creditCardYear")).getAttribute("value");
        assertThat(value, is(ccYear));

        value = webDriver.findElement(By.id("nameOnCard")).getAttribute("value");
        assertThat(value, is(ccName));
    }
}
