package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateOrderPage {
    WebDriver driver;

    public CreateOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void orderValidation(){
        String expectedResult = "Your order has been successfully processed!";
        String actualResult = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}