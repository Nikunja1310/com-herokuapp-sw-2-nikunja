package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */
public class WrongCodeLoginTest extends BaseTest {
    String baseURL = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

        //Verify the Text
        String actualText = driver.findElement(By.xpath("//i[contains(@class,'icon-lo')]")).getText();
        String expectedText = "Secure Area";
        Assert.assertEquals("Verified the text “Secure Area” ",expectedText,actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        //Verify Error message
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        String expectedText = "Your username is invalid!";
        Assert.assertEquals("Verified the error message “Your username\n" +
                "is invalid!",expectedText,actualText);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        //Verify Error message
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        String expectedText = "Your password\n" +
                "is invalid!";

        Assert.assertEquals("Verified the error message “Your password\n" +
                "is invalid!” ",expectedText,actualText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
