package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SeleniumHomework2 {
    @Test
    public void testCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");


        String title = driver.getTitle();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(title,expectedTitle);

        WebElement userName= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement passWord= driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passWord.sendKeys("test");
        WebElement loginButton=driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        Thread.sleep(1000);
        String title2= driver.getTitle();
        String expectedTitle2="Web Orders";
        Assert.assertEquals(title2,expectedTitle2);
        WebElement header=driver.findElement(By.xpath("//div//h2"));
        String expectedHeader="List of All Orders";
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);

    }
    @Test
    public void testCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String title = driver.getTitle();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(title,expectedTitle);
        WebElement userName= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement passWord= driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passWord.sendKeys("test");
        WebElement loginButton=driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement viewAllProductsButton=driver.findElement(By.xpath("//a[.='View all products']"));
        viewAllProductsButton.click();
        Thread.sleep(1000);
        viewAllProductsButton=driver.findElement(By.xpath("//a[.='View all products']"));
        if(viewAllProductsButton.isSelected()){
            System.out.println("View all products is validated");
        }

        WebElement header=driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowserUtils.getText(header),"List of Products");
        System.out.println(driver.getCurrentUrl());
        String url= driver.getCurrentUrl();
        System.out.println(url.contains("Products")? "URL is validated": "URL is NOT validated");


    }
    @Test
    public void testCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String title = driver.getTitle();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(title,expectedTitle);
        WebElement userName= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement passWord= driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passWord.sendKeys("test");
        WebElement loginButton=driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        WebElement viewAllProducts =driver.findElement(By.xpath("//a[.='View all products']"));
        viewAllProducts.click();

        WebElement allOrders=driver.findElement(By.xpath("//a[.='View all orders']"));
        WebElement allProducts=driver.findElement(By.xpath("//a[.='View all products']"));
        WebElement orders=driver.findElement(By.xpath("//a[.='Order']"));

        String value1 = allOrders.getAttribute("href");
        String value2 = allProducts.getAttribute("href");
        String value3 = orders.getAttribute("href");

        Thread.sleep(2000);
        Assert.assertTrue(value1.contains("Default.aspx"));
        Assert.assertTrue(value2.contains("Products.aspx"));
        Assert.assertTrue(value3.contains("Process.aspx"));

    }
    @Test
    public void TestCase4(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement passWord= driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passWord.sendKeys("test");
        WebElement loginButton=driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        WebElement orderButton=driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();
        WebElement productDropDown=driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        BrowserUtils.selectBy(productDropDown,"ScreenSaver","value");
        WebElement quantityDrop=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantityDrop.sendKeys("5");
        WebElement customer=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customer.sendKeys("CodeFish IT School");
        WebElement street=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        WebElement state=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");
        WebElement zip=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zip.sendKeys("60018");
        WebElement masterCard= driver.findElement(By.xpath("//input[@value='MasterCard']"));
        masterCard.click();
        WebElement creditCard= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        creditCard.sendKeys("444993876233");
        WebElement expirDate=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expirDate.sendKeys("03/24");
        WebElement processButton=driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();
        WebElement message= driver.findElement(By.xpath("//strong"));
        Assert.assertTrue(message.isDisplayed());
        WebElement viewAllOrder=driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAllOrder.click();
        List<WebElement> actualList=driver.findElements(By.xpath("//tr[2]//td"));
        List<String> expectedList= Arrays.asList("CodeFish IT School","ScreenSaver","5","06/04/2023","2200 E devon","Des Plaines",
                "Illinois","60018","MasterCard","444993876233","03/24");
        for(int i= 1,j=0; i <actualList.size()-1;i++,j++){
            Assert.assertEquals(BrowserUtils.getText(actualList.get(i)),expectedList.get(j));
            System.out.println(actualList.get(i).getText());
        }
    }

}
