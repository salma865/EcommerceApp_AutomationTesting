package StepDefinitions;

import Pages.LoginPage;
import Pages.SearchPage;
import Pages.SwitchCurrenciesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchCurrenciesSD {
    public WebDriver driver = null;
    LoginPage L1;
    SearchPage P1;
    SwitchCurrenciesPage S1;

    @Given("browser opened and user login successfully")
    public void browserOpenedAndUserLoginSuccessfully() throws InterruptedException {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        S1 = new SwitchCurrenciesPage(driver);
        P1 = new SearchPage(driver);
        L1 = new LoginPage(driver);
        L1.click_login();
        L1.Login("newuser@gmail.com","208010");
        L1.click_login_button();
        Thread.sleep(2000);
    }

    @And("^user search for \"(.*)\" and search completed successfully$")
    public void userSearch(String word) throws InterruptedException {
        P1.search(word);
        Thread.sleep(2000);
    }

    @When("user switch to Euro")
    public void userSwitchToEuro() throws InterruptedException {
        S1.switchToEuro();
        Thread.sleep(2000);
    }

    @Then("currency is Euro")
    public void currencyIsEuro() throws InterruptedException {
        S1.validateCurrencyIsEuro();
    }

    @When("user switch to US")
    public void userSwitchToUS() throws InterruptedException {
        S1.switchToUS();
        Thread.sleep(2000);
    }

    @Then("currency is US")
    public void currencyIsUS() throws InterruptedException {
        S1.validateCurrencyIsUS();
    }
}
