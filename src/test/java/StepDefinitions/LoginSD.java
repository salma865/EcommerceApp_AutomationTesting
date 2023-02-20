package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        L1.click_login();
        Thread.sleep(2000);
    }

    @When("user enter valid email and password")
    public void userEnterValidEmailAndPassword(){
        L1.Login("newuser@gmail.com","208010");
    }

    @And("user click login button")
    public void userClickLoginButton() throws InterruptedException {
        L1.click_login_button();
        Thread.sleep(2000);
    }

    @Then("user could login")
    public void userCouldLogin() throws InterruptedException {
        L1.validate_SC1();
    }

    @When("user enter invalid email and password")
    public void userEnterInvalidEmailAndPassword(){
        L1.Login("salma@gmail.com","1234");
    }

    @Then("user couldn't login")
    public void userCouldNotLogin() throws InterruptedException {
        L1.validate_SC2();
    }

}
