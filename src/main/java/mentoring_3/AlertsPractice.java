package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsPractice {
    @Test
    public void TC_05() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");
        WebElement javaScriptAlertButton= driver.findElement(By.xpath("//p[contains(.,'JS Alert')]//following-sibling::button"));
        javaScriptAlertButton.click();
        Thread.sleep(2000);
        WebElement JsAlertCLick= driver.findElement(By.xpath("//p[contains(.,'Confirm box')]//following-sibling::button"));
        JsAlertCLick.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement prompt=driver.findElement(By.xpath("//p[contains(.,'Prompt box:')]//following-sibling::button"));
        prompt.click();






    }
}
