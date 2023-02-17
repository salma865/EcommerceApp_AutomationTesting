package StepDefinitions;

import Pages.LoginPage;
import Pages.SearchPage;
import Pages.SelectCategoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
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
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(1000);
        L1.Login("newuser@gmail.com","208010");
        driver.findElement(By.className("login-button")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
        Thread.sleep(2000);
    }

    @When("user select category")
    public void userSelectCategory(){
        S1.SelectCategory();
    }

    @Then("selected category page is opened")
    public void selectedCategoryPageIsOpened() throws InterruptedException {
        S1.validation();
        Thread.sleep(1000);
        driver.quit();
    }
}
