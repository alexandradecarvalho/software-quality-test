package tqs.lab3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class LoginPage {
    private WebDriver driver;

    @FindBy(name="password")
    private WebElement user_password;

    @FindBy(className="h3")
    private WebElement label;

    @FindBy(css="#content")
    private WebElement text;

    @FindBy(how= How.CSS,using="div[class=’yt-lockup-tile yt-lockup-video’]")
    private List<WebElement> videoElements;

    @FindAll({@FindBy(how=How.ID, using="username"),
            @FindBy(className="username-field")})
    private WebElement user_name;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
