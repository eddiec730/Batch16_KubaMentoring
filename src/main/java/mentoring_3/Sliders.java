package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class Sliders {
    @Test
    public void sliderTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");

        driver.findElement(By.xpath("//a[contains(.,'Drag & Drop Sliders')]")).click();
        List<WebElement> allInputs = driver.findElements(By.xpath("//input[@type='range']"));
        List<WebElement> allOutputs = driver.findElements(By.cssSelector("output"));

        for (int i = 0; i < allInputs.size(); i++) {
            while (!allOutputs.get(i).getText().equals("50")) {
                if(allOutputs.get(i).getText().equals("50")){
                    break;
                }else{
                    allInputs.get(i).sendKeys(Keys.ARROW_RIGHT);
                }
            }


        }

    }

}