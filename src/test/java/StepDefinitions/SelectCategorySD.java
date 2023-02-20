package StepDefinitions;

import Pages.LoginPage;
import Pages.SelectCategoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCategorySD {

    public WebDriver driver = null;
    LoginPage L1;
    SelectCategoryPage S1;

    @Given("login done successfully")
    public void loginDoneSuccessfully() throws InterruptedException {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        L1 = new LoginPage(driver);
        S1 = new SelectCategoryPage(driver);
        L1.click_login();
        L1.Login("newuser@gmail.com","208010");
        L1.click_login_button();
        Thread.sleep(2000);
    }

    @When("user select category")
    public void userSelectCategory(){
        S1.SelectCategory();
    }

    @Then("selected category page is opened")
    public void selectedCategoryPageIsOpened() throws InterruptedException {
        S1.validation();
    }
}
