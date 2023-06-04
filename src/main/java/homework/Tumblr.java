package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Tumblr {
    @Test
    public void testCase1() throws InterruptedException {
        /*
        click login button
        click continue with email button
        provide email, and password (wrong credentials)
        and validate the error message
        driver quit

         */
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tumblr.com/");

        WebElement loginButton= driver.findElement(By.xpath("//a[.='Log in']"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement continueWithEmailButton= driver.findElement(By.xpath("//button[.='Continue with email']"));
        continueWithEmailButton.click();
        Thread.sleep(1000);
        WebElement emailEnter=driver.findElement(By.xpath("//input[@name='email']"));
        emailEnter.sendKeys("eddie@gmail.com");
        WebElement nextButton= driver.findElement(By.xpath("//button[@class='TRX6J CxLjL qjTo7 CguuB qNKBC']"));
        nextButton.click();
        Thread.sleep(3000);
        WebElement passWordInput=driver.findElement(By.xpath("//input[@name='password']"));
        passWordInput.sendKeys("abcd");
        WebElement nextButtonForPassword= driver.findElement(By.xpath("//button[@type='submit']"));
        nextButtonForPassword.click();
        Thread.sleep(3000);
        WebElement message=driver.findElement(By.xpath("//div[contains(text(),'incorrect')]"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="Your email or password were incorrect.";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
