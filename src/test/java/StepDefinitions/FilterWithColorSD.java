package StepDefinitions;

import Pages.FilterWithColorPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FilterWithColorSD {
    public WebDriver driver = null;
    LoginPage L1;
    FilterWithColorPage F1;

    @Given("user login")
    public void userLogin() throws InterruptedException {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        L1 = new LoginPage(driver);
        F1 = new FilterWithColorPage(driver);
        L1.click_login();
        L1.Login("newuser@gmail.com","208010");
        L1.click_login_button();
        Thread.sleep(2000);
    }

    @And("user select category Apparel > Shoes")
    public void userSelectCategoryApparel_Shoes(){
        F1.choseCategories();
    }

    @When("user filter with color red")
    public void userFilterWithColorRed(){
        F1.filterWithRed();
    }

    @Then("only red elements should appear")
    public void onlyRedElementsShouldAppear() throws InterruptedException {
        F1.validation();
    }
}
