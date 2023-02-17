package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
    WebDriver driver;
    public ResetPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void resetPassword(String E_mail){
        driver.findElement(By.id("Email")).sendKeys(E_mail);
    }
}
