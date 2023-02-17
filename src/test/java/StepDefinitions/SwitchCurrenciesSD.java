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
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        L1.Login("newuser@gmail.com","208010");
        driver.findElement(By.className("login-button")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
        Thread.sleep(2000);
    }

    @And("^user search for \"(.*)\" and search completed successfully$")
    public void userSearch(String word) throws InterruptedException {
        P1.search(word);
        Thread.sleep(2000);
        String expectedResult = "https://demo.nopcommerce.com/search?q=Apple+iCam";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @When("user switch to Euro")
    public void userSwitchToEuro() throws InterruptedException {
        S1.switchToEuro();
        Thread.sleep(2000);
    }

    @Then("currency is Euro")
    public void currencyIsEuro() throws InterruptedException {
        String expectedResult = "€";
        String actualResult = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/span")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);
        driver.quit();
    }

    @When("user switch to US")
    public void userSwitchToUS() throws InterruptedException {
        S1.switchToUS();
        Thread.sleep(2000);
    }

    @Then("currency is US")
    public void currencyIsUS() throws InterruptedException {
        String expectedResult = "$";
        String actualResult = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/span")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);
        driver.quit();
    }
}
