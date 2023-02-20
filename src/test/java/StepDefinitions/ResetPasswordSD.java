package StepDefinitions;

import Pages.ResetPasswordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResetPasswordSD {
    public WebDriver driver = null;
    ResetPasswordPage reset1;

    @Given("browser opened")
    public void browserOpened(){
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        reset1 = new ResetPasswordPage(driver);
    }

    @And("website opened")
    public void websiteOpened(){
        reset1.open_website();
    }

    @And("user navigate to login page")
    public void userNavigateToLoginPage() throws InterruptedException {
        reset1.click_login();
        Thread.sleep(2000);
    }

    @When("user click on forgot password and reset password page is opened")
    public void userClickOnForgotPasswordAndResetPasswordPageIsOpened(){
        reset1.click_forgetPass();
    }

    @And("user enter his email")
    public void userEnterHisEmail(){
        reset1.resetPassword("newuser@gmail.com");
    }

    @And("user click on recover button")
    public void userClickOnRecoverButton() throws InterruptedException {
        reset1.click_recover();
        Thread.sleep((2000));
    }

    @Then("reset mail is send to the user")
    public void resetMailIsSendToTheUser() throws InterruptedException {
        reset1.validation();
    }

}
