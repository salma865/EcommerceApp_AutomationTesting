package StepDefinitions;

import Pages.AddToShoppingCartPage;
import Pages.CreateOrderPage;
import Pages.LoginPage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.findElement(By.className("ico-login")).click();
        Thread.sleep(1000);
        L1.Login("newuser@gmail.com","208010");
        driver.findElement(By.className("login-button")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
        Thread.sleep(1000);
    }

    @And("^search for \"(.*)\" product successfully$")
    public void makeOrderSearch(String word){
        P1.search(word);
        String expectedResult = "https://demo.nopcommerce.com/search?q=Windows+8+Pro";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @And("user add product to shopping cart successfully and open cart")
    public void userAddProductToShoppingCartSuccessfully() throws InterruptedException {
        A1.addToCart();
        Thread.sleep(1000);
        driver.navigate().to("https://demo.nopcommerce.com/cart");

    }

    @When("user agree with terms")
    public void userAgreeWithTerms(){
        driver.findElement(By.id("termsofservice")).click();
    }

    @And("user click checkout")
    public void userClickCheckout() throws InterruptedException {
        driver.findElement(By.name("checkout")).click();
        Thread.sleep(1000);
    }

    @And("user fill Billing address data")
    public void userFill_BillingAddress_Data() throws InterruptedException {
        C1.addressData();
        Thread.sleep(1000);
    }

    @And("user chose Shipping method")
    public void userChoseShippingMethod(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")).click();
    }

    @And("user chose Payment method")
    public void userChosePaymentMethod() throws InterruptedException {
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button"));
        button.click();
    }

    @And("user read Payment information and continue")
    public void userReadPaymentInformationAndContinue() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button")).click();
    }

    @And("user confirm order")
    public void userConfirmOrder() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[2]/button")).click();
        Thread.sleep(1000);
    }

    @Then("order created successfully")
    public void orderCreatedSuccessfully() throws InterruptedException {
        C1.orderValidation();
        Thread.sleep(2000);
        driver.quit();
    }

}
