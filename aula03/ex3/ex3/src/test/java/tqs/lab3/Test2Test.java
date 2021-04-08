package tqs.lab3;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SeleniumJupiter.class)
public class Test2Test {

    @Test
    public void test1(ChromeDriver driver) {
        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(1294, 741));
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'Mexico City']")).click();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.name("fromPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.findElement(By.xpath("//option[. = 'Cairo']")).click();
        }
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.name("toPort"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        {
            String value = driver.findElement(By.name("fromPort")).getAttribute("value");
            assertThat(value, is("Mexico City"));
        }
        {
            String value = driver.findElement(By.name("toPort")).getAttribute("value");
            assertThat(value, is("Cairo"));
        }
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(5) .btn")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("John Snow");
        driver.findElement(By.id("address")).sendKeys("123 Main Street");
        driver.findElement(By.id("city")).sendKeys("Mexico City");
        driver.findElement(By.id("state")).sendKeys("Mexico");
        driver.findElement(By.id("zipCode")).sendKeys("12345");
        {
            WebElement element = driver.findElement(By.id("cardType"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.id("cardType"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.id("cardType"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("12345678910");
        driver.findElement(By.id("creditCardMonth")).click();
        driver.findElement(By.id("creditCardMonth")).sendKeys("05");
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).sendKeys("2022");
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys("John Snow");
        {
            String value = driver.findElement(By.id("inputName")).getAttribute("value");
            assertThat(value, is("John Snow"));
        }
        {
            String value = driver.findElement(By.id("address")).getAttribute("value");
            assertThat(value, is("123 Main Street"));
        }
        {
            String value = driver.findElement(By.id("city")).getAttribute("value");
            assertThat(value, is("Mexico City"));
        }
        {
            String value = driver.findElement(By.id("state")).getAttribute("value");
            assertThat(value, is("Mexico"));
        }
        {
            String value = driver.findElement(By.id("zipCode")).getAttribute("value");
            assertThat(value, is("12345"));
        }
        {
            String value = driver.findElement(By.id("cardType")).getAttribute("value");
            assertThat(value, is("visa"));
        }
        {
            String value = driver.findElement(By.id("creditCardNumber")).getAttribute("value");
            assertThat(value, is("12345678910"));
        }
        {
            String value = driver.findElement(By.id("creditCardMonth")).getAttribute("value");
            assertThat(value, is("1105"));
        }
        {
            String value = driver.findElement(By.id("creditCardYear")).getAttribute("value");
            assertThat(value, is("20172022"));
        }
        {
            String value = driver.findElement(By.id("nameOnCard")).getAttribute("value");
            assertThat(value, is("John Snow"));
        }
        driver.findElement(By.id("rememberMe")).click();
        assertTrue(driver.findElement(By.id("rememberMe")).isSelected());
        driver.findElement(By.cssSelector(".btn-primary")).click();
        assertThat(driver.getTitle(), is("BlazeDemo Confirmation"));
    }

}
