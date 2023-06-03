package lamba_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;
import java.util.TreeMap;

public class Test2 {
    /*
    print out names and emails as a key-value pair
    use map interface, try to use cssSelector
     */
    @Test
    public void TC_01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");

        driver.findElement(By.xpath("//a[.='Table Pagination']")).click();

        WebElement selectButton = driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(selectButton, "5000", "value");
        WebElement names = driver.findElement(By.xpath("//tr"));

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));


        for (int i = 0; i < allNames.size(); i++) {
            TreeMap<String, String> map = new TreeMap<>();
            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmails.get(i)));
            System.out.println(map);
        }

    }

    @Test
    public void TC_02() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");

        driver.findElement(By.xpath("//a[.='Table Pagination']")).click();

        WebElement selectButton = driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(selectButton, "5000", "value");
        WebElement names = driver.findElement(By.xpath("//tr"));

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allPhoneNumber = driver.findElements(By.xpath("//tr//td[4]"));

        TreeMap<String, Long> map=new TreeMap<>();
        for(int i=0;i <allNames.size();i++){
            map.put(BrowserUtils.getText(allNames.get(i)),Long.valueOf(BrowserUtils.getText(allPhoneNumber.get(i)).replace("-", "")));
        }
        System.out.println("Map = " + map);



    }


}

