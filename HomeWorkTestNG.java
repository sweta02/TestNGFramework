package testNGHomework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeWorkTestNG {
    WebDriver driver;

    @BeforeClass
    void openBrowser() throws InterruptedException {
        System.out.println("Open Browser");
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(1000);
    }
    @Test(priority = 1)
    void select() throws InterruptedException {
        System.out.println("Select Lenova IdeaCentre 600 All in one PC ");
        driver.findElement(By.xpath("//a[@href= '/computers']")).click();
        driver.findElement(By.xpath("//img[@alt= 'Picture for category Desktops']")).click();
        driver.findElement(By.xpath("//img[@title= 'Show details for Lenovo IdeaCentre 600 All-in-One PC']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    void addToCArt() throws InterruptedException {
        System.out.println("Lenova PC added to Cart");
        driver.findElement(By.id("add-to-cart-button-3")).click();
      // driver.findElement(By.xpath("//span[@class= 'close']")).click();
        WebElement Cart = driver.findElement(By.className("cart-label"));
        Assert.assertTrue(Cart.isDisplayed(), "The product has been added to your cart");
        //Assert.assertFalse(Cart.isDisplayed(),"The product has been added to your ");
        Thread.sleep(6000);
    }
    @Test(priority = 3)
    void shoppingCart() throws InterruptedException {
        System.out.println("Product updated to quantity 3");
        driver.findElement(By.xpath("//span[@class= 'cart-label']")).click();
        WebElement updateCart =  driver.findElement(By.xpath("//input[@value= '1']"));
        updateCart.clear();
        updateCart.sendKeys("3");
        driver.findElement(By.id("updatecart")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.xpath("//button[@id= 'checkout']")).click();
    }
    @Test(priority = 4)
    void checkOut() throws InterruptedException {
        System.out.println("Checkout as Guest");
        driver.findElement(By.xpath("//button[@class= 'button-1 checkout-as-guest-button']")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 5)
    void billing() throws InterruptedException {
        System.out.println("Billing Information entered");
        driver.findElement(By.xpath("//input[@id='ShipToSameAddress']")).click();
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("Somert");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("john169@gmail.com");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']")).sendKeys("Sitcom");
        driver.findElement(By.xpath("//select[@data-val-required= 'Country is required.']")).sendKeys("United Kingdom");
        driver.findElement(By.xpath("//select[@data-trigger= 'state-select']")).sendKeys("Other");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Wimbledon");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("1st Floor");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address2']")).sendKeys("Charles Avenue");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("SW12 7LP");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("07856222222");
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_FaxNumber']")).sendKeys("454545444");
        driver.findElement(By.xpath("//button[@class= 'button-1 new-address-next-step-button']")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 6)
    void shippingMethod() throws InterruptedException {
        System.out.println("Selected shipping method");
        //driver.findElement(By.xpath("//*[@id=\"shipping-methods-form\"]/ul/li[1]/div[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/button[4]")).click();
       // driver.findElement(By.xpath("//*[@id=\"shippingoption_0\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type= 'button' and @onclick= 'ShippingMethod.save()']")).click();
        Thread.sleep(2000);

    }
    @Test(priority = 7)
    void paymentMethod() throws InterruptedException {
        System.out.println("Selected Payment Method");
        WebElement radio = driver.findElement(By.xpath("//input[@id= 'paymentmethod_1']"));
        radio.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();

    }
    @Test(priority = 8)
    void paymentInfo() throws InterruptedException {
        System.out.println("Payment information entered");
        Thread.sleep(2000);
        Select select =  new Select(driver.findElement(By.xpath("//*[@id=\"CreditCardType\"]")));
        select.selectByValue("MasterCard");
        driver.findElement(By.xpath("//input[@data-val-required= 'Enter cardholder name']")).sendKeys("John Somert");
        driver.findElement(By.xpath("//input[@id= 'CardNumber']")).sendKeys("2589 565 5566 5555");
        driver.findElement(By.xpath("//select[@id= 'ExpireMonth']")).sendKeys("04");
        driver.findElement(By.xpath("//select[@id= 'ExpireYear']")).sendKeys("2027");
        driver.findElement(By.xpath("//input[@id= 'CardCode']")).sendKeys("1155");
        driver.findElement(By.xpath("//button[@class= 'button-1 payment-info-next-step-button']")).click();
        Thread.sleep(3000);
    }
    @AfterClass
    void closeBrowser(){
        System.out.println("Close Browser");
        driver.close();
   }
}
