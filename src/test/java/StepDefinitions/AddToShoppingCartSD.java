package StepDefinitions;

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

public class AddToShoppingCartSD {
    public WebDriver driver = null;
    LoginPage L1;
    SearchPage P1;
    AddToShoppingCartPage A1;

    @Given("login done")
    public void loginDone() throws InterruptedException {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        P1 = new SearchPage(driver);
        L1 = new LoginPage(driver);
        A1 = new AddToShoppingCartPage(driver);
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(1000);
        L1.Login("newuser@gmail.com","208010");
        driver.findElement(By.className("login-button")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
        Thread.sleep(1000);
    }

    @And("^searching for \"(.*)\"$")
    public void toCartSearch(String word) throws InterruptedException {
        P1.search(word);
        //Thread.sleep(1000);
        String expectedResult = "https://demo.nopcommerce.com/search?q=Portable+Sound+Speakers";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @When("user click add to cart button")
    public void userClickAddToCartButton(){
        A1.addToCart();
    }

    @Then("item should be added to cart")
    public void itemShouldBeAddedToCart() throws InterruptedException {
        A1.checkCart();
        Thread.sleep(2000);
        driver.quit();
    }
}
