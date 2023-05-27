package lamba_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test1 {

    //go with test autmation @Test
    @Test
   public void TC_01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        WebElement inputButton=driver.findElement(By.xpath("//a[contains(text(),'Input Form Submit')]"));
        inputButton.click();
        Thread.sleep(2000);

        WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("Edward");

        WebElement email=driver.findElement(By.xpath("//input[@id='inputEmail4']"));
        email.sendKeys("eddiec@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@id='inputPassword4']"));
        password.sendKeys("123");

        WebElement company=driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("Techtorial");

        WebElement website=driver.findElement(By.xpath("//input[@id='websitename']"));
        website.sendKeys("gmail.com");

        WebElement country=driver.findElement(By.xpath("//select[@name='country']"));
        country.sendKeys("Albania");

        WebElement city=driver.findElement(By.xpath("//input[@id='inputCity']"));
        city.sendKeys("Chicago");

        WebElement address1=driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("123 House");

        WebElement address2=driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("Apt2");

        WebElement state=driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("New York");

        WebElement zipCode=driver.findElement(By.xpath("//input[@id='inputZip']"));
        zipCode.sendKeys("12345");

       WebElement submitButton=driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();
        Thread.sleep(2000);

        List<WebElement> allMessages= driver.findElements(By.xpath("//p"));
        for(int i =0; i < allMessages.size(); i++){
             if(allMessages.get(i).getText().contains("Thanks")){
                  System.out.println(allMessages.get(i).getText());
                  Assert.assertTrue(allMessages.get(i).isDisplayed());
             }
        }
        System.out.println("this one for github");







    }

}
