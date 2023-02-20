package StepDefinitions;

import Pages.AddToWishlistPage;
import Pages.LoginPage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToWishlistSD {
    public WebDriver driver = null;
    LoginPage L1;
    SearchPage P1;
    AddToWishlistPage A1;

    @Given("user is logged in")
    public void userIsLoggedIn() throws InterruptedException {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        P1 = new SearchPage(driver);
        L1 = new LoginPage(driver);
        A1 = new AddToWishlistPage(driver);
        L1.click_login();
        L1.Login("newuser@gmail.com","208010");
        L1.click_login_button();
        Thread.sleep(1000);
    }

    @And("^searching for item \"(.*)\" done$")
    public void wishlistSearch(String word){
        P1.search(word);
        A1.validate_search();
    }

    @When("user click add to wishlist button")
    public void userClickAddToWishlistButton(){
        A1.addToWishlist();
    }

    @Then("item should be added to wishlist")
    public void itemShouldBeAddedToWishlist() throws InterruptedException {
        A1.checkWishlist();
    }
}
