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
        L1.click_login();
        L1.Login("newuser@gmail.com","208010");
        L1.click_login_button();
        Thread.sleep(1000);
    }

    @And("^search for \"(.*)\"$")
    public void searchFor(String word) throws InterruptedException {
        P1.search(word);
        Thread.sleep(1000);
    }

    @And("search results appear")
    public void searchResultsAppear(){
        S1.validate_search();
    }

    @When("^user select \"(.*)\" tag$")
    public void userSelectTag(String tag) throws InterruptedException {
        S1.selectTag(tag);
        Thread.sleep(1000);
    }

    @Then("^validate selecting \"(.*)\" tag$")
    public void validateSelectingTags(String tag) throws InterruptedException {
        S1.validation(tag);
    }
}
