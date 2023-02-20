package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void click_login(){
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
    }

    public void Login(String E_mail , String Password){
        driver.findElement(By.id("Email")).sendKeys(E_mail);
        driver.findElement(By.id("Password")).sendKeys(Password);
    }

    public void click_login_button(){
        driver.findElement(By.className("login-button")).click();
    }

    public void validate_SC1() throws InterruptedException {
        String expected =  "https://demo.nopcommerce.com/";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual,expected);
        Thread.sleep(2000);
        driver.quit();
    }

    public void validate_SC2() throws InterruptedException {
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.";
        String actualResult = driver.findElement(By.className("message-error")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(2000);
        driver.quit();
    }
}
