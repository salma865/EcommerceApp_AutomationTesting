package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
    WebDriver driver;
    public ResetPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void open_website(){
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    public void click_login(){
        driver.findElement(By.className("ico-login")).click();
    }

    public void click_forgetPass(){
        driver.findElement(By.className("forgot-password")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/passwordrecovery"));
    }

    public void resetPassword(String E_mail){
        driver.findElement(By.id("Email")).sendKeys(E_mail);
    }

    public void click_recover(){
        driver.findElement(By.name("send-email")).click();
    }

    public void validation() throws InterruptedException {
        String expectedResult = "Email with instructions has been sent to you.";
        String actualResult = driver.findElement(By.className("content")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep((2000));
        driver.quit();
    }
}
