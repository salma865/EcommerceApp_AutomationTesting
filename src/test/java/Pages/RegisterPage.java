package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void navigation(){
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    public void click_register(){
        driver.findElement(By.className("ico-register")).click();
    }

    public void enterRegistrationData(String FName , String LName , String B_day , String B_month , String B_year , String E_mail , String Password , String ConfirmPassword){
        //Gender Data
        driver.findElement(By.id("gender-female")).click();
        //First Name
        driver.findElement(By.id("FirstName")).sendKeys(FName);
        //Last Name
        driver.findElement(By.id("LastName")).sendKeys(LName);
        //Date Of Birth
        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        day.selectByValue(B_day);
        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByValue(B_month);
        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByValue(B_year);
        //Email
        driver.findElement(By.id("Email")).sendKeys(E_mail);
        //Password
        driver.findElement(By.id("Password")).sendKeys(Password);
        //Confirm Password
        driver.findElement(By.id("ConfirmPassword")).sendKeys(ConfirmPassword);
    }

    public void click_reg_button(){
        driver.findElement(By.id("register-button")).click();
    }

    public void validation() throws InterruptedException {
        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(By.className("result")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);
        driver.quit();
    }
}
