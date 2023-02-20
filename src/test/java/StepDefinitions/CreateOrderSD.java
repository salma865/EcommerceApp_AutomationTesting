package StepDefinitions;

import Pages.AddToShoppingCartPage;
import Pages.CreateOrderPage;
import Pages.LoginPage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrderSD {
    public WebDriver driver = null;
    LoginPage L1;
    SearchPage P1;
    AddToShoppingCartPage A1;
    CreateOrderPage C1;

    @Given("user login to create order")
    public void userLoginToCreateOrder() throws InterruptedException {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        P1 = new SearchPage(driver);
        L1 = new LoginPage(driver);
        A1 = new AddToShoppingCartPage(driver);
        C1 = new CreateOrderPage(driver);
        L1.click_login();
        L1.Login("newuser@gmail.com","208010");
        L1.click_login_button();
        Thread.sleep(1000);
    }

    @And("^search for \"(.*)\" product successfully$")
    public void makeOrderSearch(String word){
        P1.search(word);
        C1.validate_search();
    }

    @And("user add product to shopping cart successfully and open cart")
    public void userAddProductToShoppingCartSuccessfully() throws InterruptedException {
        A1.addToCart();
        Thread.sleep(1000);
    }

    @When("user agree with terms")
    public void userAgreeWithTerms() throws InterruptedException {
        C1.agreeWithTerms();
    }

    @And("user click checkout")
    public void userClickCheckout() throws InterruptedException {
        C1.click_checkout();
        Thread.sleep(1000);
    }

    @And("user fill Billing address data")
    public void userFill_BillingAddress_Data() throws InterruptedException {
        C1.addressData();
        Thread.sleep(1000);
    }

    @And("user chose Shipping method")
    public void userChoseShippingMethod(){
        C1.chose_shippingMethod();
    }

    @And("user chose Payment method")
    public void userChosePaymentMethod() throws InterruptedException {
        Thread.sleep(2000);
        C1.chose_paymentMethod();
    }

    @And("user read Payment information and continue")
    public void userReadPaymentInformationAndContinue() throws InterruptedException {
        Thread.sleep(3000);
        C1.payment_info();
    }

    @And("user confirm order")
    public void userConfirmOrder() throws InterruptedException {
        Thread.sleep(2000);
        C1.confirm_order();
        Thread.sleep(1000);
    }

    @Then("order created successfully")
    public void orderCreatedSuccessfully() throws InterruptedException {
        C1.orderValidation();
    }

}
