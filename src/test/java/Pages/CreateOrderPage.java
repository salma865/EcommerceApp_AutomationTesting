package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateOrderPage {
    WebDriver driver;

    public CreateOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validate_search(){
        String expectedResult = "https://demo.nopcommerce.com/search?q=Windows+8+Pro";
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    public void agreeWithTerms() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/cart");
        Thread.sleep(1000);
        driver.findElement(By.id("termsofservice")).click();
    }

    public void click_checkout(){
        driver.findElement(By.name("checkout")).click();
    }

    public void BillingAddress(String city , String address , String postal_code , String phone_number){
            //select country
            Select countrySelect = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
            countrySelect.selectByValue("123");
            //add city data
            driver.findElement(By.id("BillingNewAddress_City")).sendKeys(city);
            //add address data
            driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(address);
            //add postal_code
            driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(postal_code);
            //add phone_number
            driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(phone_number);
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/div/button[4]")).click();
    }

    public void addressData(){
        int x = driver.findElements(By.id("billing-address-select")).size();
        if(x > 0){
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/div/button[4]")).click();
        }
        else{
            BillingAddress("Heliopolis","10-street","1234","01122334455");
        }

    }

    public void chose_shippingMethod(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button")).click();
    }

    public void chose_paymentMethod(){
        WebElement button = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button"));
        button.click();
    }

    public void payment_info(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button")).click();
    }

    public void confirm_order(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[2]/button")).click();
    }

    public void orderValidation() throws InterruptedException {
        String expectedResult = "Your order has been successfully processed!";
        String actualResult = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(2000);
        driver.quit();
    }
}