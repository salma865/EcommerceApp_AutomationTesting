package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void Login(String E_mail , String Password){
        driver.findElement(By.id("Email")).sendKeys(E_mail);
        driver.findElement(By.id("Password")).sendKeys(Password);
    }
}
