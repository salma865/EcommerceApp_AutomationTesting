package StepDefinitions;

import Pages.FilterWithColorPage;
import Pages.LoginPage;
import Pages.SearchPage;
import Pages.SelectTagsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectTagsSD {
    public WebDriver driver = null;
    LoginPage L1;
    SearchPage P1;
    SelectTagsPage S1;

    @Given("user open login page and login successfully")
    public void userOpenLoginPageAndLoginSuccessfully() throws InterruptedException {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        L1 = new LoginPage(driver);
        P1 = new SearchPage(driver);
        S1 = new SelectTagsPage(driver);
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(1000);
        L1.Login("newuser@gmail.com","208010");
        driver.findElement(By.className("login-button")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
        Thread.sleep(1000);
    }

    @And("^search for \"(.*)\"$")
    public void searchFor(String word) throws InterruptedException {
        P1.search(word);
        Thread.sleep(1000);
    }

    @And("search results appear")
    public void searchResultsAppear(){
        String expectedResult = "https://demo.nopcommerce.com/search?q=Vintage+Style+Engagement+Ring";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @When("^user select \"(.*)\" tag$")
    public void userSelectTag(String tag) throws InterruptedException {
        S1.selectTag(tag);
        Thread.sleep(1000);
    }

    @Then("^validate selecting \"(.*)\" tag$")
    public void validateSelectingTags(String tag) throws InterruptedException {
        S1.validation(tag);
        Thread.sleep(1000);
        driver.quit();
    }
}
