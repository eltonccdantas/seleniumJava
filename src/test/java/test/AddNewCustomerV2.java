package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverManagement;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class AddNewCustomerV2 {
    private WebDriver driver;
    DriverManagement driverManagement;

    @Before
    public void setUp() {
        System.out.println("##### Running setUp #####");
        driverManagement = new DriverManagement();
        driver = DriverManagement.startBrowser("chrome");
//        driver.get("https://demo.guru99.com/V4/");
//
//        driver.findElement(By.name("uid")).click();
//        driver.findElement(By.name("uid")).sendKeys("mngr530104");
//        //driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).click();
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("password")).sendKeys("syzahev");
//        driver.findElement(By.name("btnLogin")).click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @After
    public void tearDown() {
        driver.close();
        System.out.println("Process finished");
    }

    @Test
    public void CanAddCustomerV2() {
        System.out.println("##### Running CanAddCustomer V2 #####");

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("Admin")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();

        driver.findElement(By.xpath("//*[@class=\"oxd-select-wrapper\"]")).click();
        driver.findElement(By.xpath("")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("")).sendKeys(Keys.ARROW_DOWN);


        driver.findElement(By.xpath("//*[@class=\"oxd-select-wrapper\"]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();


//        driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
//        driver.findElement(By.xpath("button[class='oxd-button oxd-button--medium oxd-button--secondary']"))
       // driver.findElement(By.cssSelector(".bi-caret-up-fill")).click();

    }
}