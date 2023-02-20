package StepDefinitions;

import Pages.LoginPage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchSD {
    public WebDriver driver = null;
    LoginPage L1;
    SearchPage P1;

    @Given("browser opened and user navigate to login page")
    public void browserOpenedAndUserNavigateToLoginPage() throws InterruptedException {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        P1 = new SearchPage(driver);
        L1 = new LoginPage(driver);
        L1.click_login();
        Thread.sleep(2000);
    }

    @And("user enter his email and password and login successfully")
    public void userEnterHisEmailAndPasswordAndLoginSuccessfully() throws InterruptedException {
        L1.Login("newuser@gmail.com","208010");
        L1.click_login_button();
        Thread.sleep(2000);
    }

    @When("^user search for \"(.*)\"$")
    public void userSearch(String word) throws InterruptedException {
        P1.search(word);
        Thread.sleep(2000);
    }

    @Then("search completed successfully")
    public void searchCompletedSuccessfully() throws InterruptedException {
        P1.validate_search();
    }

}
