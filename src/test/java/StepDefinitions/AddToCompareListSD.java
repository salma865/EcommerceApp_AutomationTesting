package StepDefinitions;

import Pages.AddToCompareListPage;
import Pages.AddToShoppingCartPage;
import Pages.LoginPage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCompareListSD {
    public WebDriver driver = null;
    LoginPage L1;
    SearchPage P1;
    AddToCompareListPage A1;

    @Given("login succeeded")
    public void loginSucceeded() throws InterruptedException {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        P1 = new SearchPage(driver);
        L1 = new LoginPage(driver);
        A1 = new AddToCompareListPage(driver);
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(1000);
        L1.Login("newuser@gmail.com","208010");
        driver.findElement(By.className("login-button")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
        Thread.sleep(1000);
    }

    @And("^searching for \"(.*)\" succeeded$")
    public void compareListSearch(String word) throws InterruptedException {
        P1.search(word);
        //Thread.sleep(1000);
        String expectedResult = "https://demo.nopcommerce.com/search?q=Science+%26+Faith";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @When("user click add to compare list button")
    public void userClickAddToCompareListButton() throws InterruptedException {
        A1.addToCompareList();
        Thread.sleep(1000);
    }

    @Then("item should be added to compare list")
    public void itemShouldBeAddedToCompareList() throws InterruptedException {
        String expectedResult = "The product has been added to your product comparison";
        String actualResult = driver.findElement(By.className("content")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(2000);
        driver.quit();
    }
}
