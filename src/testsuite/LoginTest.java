package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    //set up base url
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUpBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidUserShouldLoginSuccessfullyWithValid() {
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify the text “Products”
        WebElement productText = driver.findElement(By.xpath("//span[@class='title']"));
        String text = productText.getText();
        System.out.println(text);
        Assert.assertEquals("Products", text);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify that six products are displayed on the page
        WebElement sixProductsDisplayed = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        String text = sixProductsDisplayed.getText();
        System.out.println(text);
    }
    @After
    public void close() {
        closeBrowser();
    }
}
