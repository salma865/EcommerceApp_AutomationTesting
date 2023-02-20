package StepDefinitions;

import Pages.AddToShoppingCartPage;
import Pages.LoginPage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        L1.click_login();
        L1.Login("newuser@gmail.com","208010");
        L1.click_login_button();
        Thread.sleep(1000);
    }

    @And("^searching for \"(.*)\"$")
    public void toCartSearch(String word){
        P1.search(word);
        A1.validate_search();
    }

    @When("user click add to cart button")
    public void userClickAddToCartButton(){
        A1.addToCart();
    }

    @Then("item should be added to cart")
    public void itemShouldBeAddedToCart() throws InterruptedException {
        A1.checkCart();
    }
}
