package StepDefinitions;

import Pages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterSD {
    public WebDriver driver = null;
    RegisterPage r1 ;

    @Given("browser opened to register")
    public void browserOpenedToRegister() throws InterruptedException {
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        r1 = new RegisterPage(driver);
    }

    @And("website opened to register")
    public void websiteOpenedToRegister() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(2000);

    }

    @And("user navigate to registration page")
    public void userNavigateToRegistrationPage(){
        driver.findElement(By.className("ico-register")).click();
    }

    @When("user enter valid data")
    public void userEnterValidData(){
        r1.enterRegistrationData("Salma","Ramy","16","8","2002","newuser@gmail.com","208010","208010");
    }

    @And("user click on register button")
    public void userClickOnRegisterButton() throws InterruptedException {
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
    }

    @Then("user are registered successfully")
    public void userAreRegisteredSuccessfully() throws InterruptedException {
        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(By.className("result")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);
        driver.quit();
    }

}
