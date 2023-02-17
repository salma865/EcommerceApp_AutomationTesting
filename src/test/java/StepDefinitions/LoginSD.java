package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.build.Plugin;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSD {
    public WebDriver driver = null;
    LoginPage L1;

    @Given("browser opened to login")
    public void browserOpenedToLogin() throws InterruptedException {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        L1 = new LoginPage(driver);
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(2000);
    }

    @When("user enter valid email and password")
    public void userEnterValidEmailAndPassword(){
        L1.Login("newuser@gmail.com","208010");
    }

    @And("user click login button")
    public void userClickLoginButton() throws InterruptedException {
        driver.findElement(By.className("login-button")).click();
        Thread.sleep(2000);
    }

    @Then("user could login")
    public void userCouldLogin() throws InterruptedException {
        String expected =  "https://demo.nopcommerce.com/";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual,expected);
        Thread.sleep(2000);
        driver.quit();
    }

    @When("user enter invalid email and password")
    public void userEnterInvalidEmailAndPassword(){
        L1.Login("salma@gmail.com","1234");
    }

    @Then("user couldn't login")
    public void userCouldNotLogin() throws InterruptedException {
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.";
        String actualResult = driver.findElement(By.className("message-error")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(2000);
        driver.quit();
    }

}
