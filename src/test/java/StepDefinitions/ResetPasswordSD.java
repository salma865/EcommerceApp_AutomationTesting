package StepDefinitions;

import Pages.ResetPasswordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResetPasswordSD {
    public WebDriver driver = null;
    ResetPasswordPage reset1;

    @Given("browser opened")
    public void browserOpened() throws InterruptedException {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        reset1 = new ResetPasswordPage(driver);
    }

    @And("website opened")
    public void websiteOpened(){
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user navigate to login page")
    public void userNavigateToLoginPage() throws InterruptedException {
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(2000);
    }

    @When("user click on forgot password and reset password page is opened")
    public void userClickOnForgotPasswordAndResetPasswordPageIsOpened(){
        driver.findElement(By.className("forgot-password")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/passwordrecovery"));
    }

    @And("user enter his email")
    public void userEnterHisEmail(){
        reset1.resetPassword("newuser@gmail.com");
    }

    @And("user click on recover button")
    public void userClickOnRecoverButton() throws InterruptedException {
        driver.findElement(By.name("send-email")).click();
        Thread.sleep((2000));
    }

    @Then("reset mail is send to the user")
    public void resetMailIsSendToTheUser() throws InterruptedException {
        String expectedResult = "Email with instructions has been sent to you.";
        String actualResult = driver.findElement(By.className("content")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep((2000));
        driver.quit();
    }

}
