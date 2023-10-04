package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import utils.DriverManagement;

import java.time.Duration;

public class AddNewCustomer {

    private WebDriver driver;
    DriverManagement driverManagement;

    @Before
    public void setUp() {
        System.out.println("##### Running setUp #####");
        driverManagement = new DriverManagement();
        driver = DriverManagement.startBrowser("chrome");

        //Select which URL will be opened
        driver.get("https://demo.guru99.com/V4/");

        //driver.findElement(By.name("uid")).click();
        driver.findElement(By.name("uid")).sendKeys("mngr530104");
        //driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).click();
        //driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("syzahev");
        driver.findElement(By.name("btnLogin")).click();
        System.out.println("setUp Worked fine");

    }

    @After
    public void tearDown() {
       // driver.close();
        System.out.println("Process finished");
    }

    @Test
    public void CanAddCustomer() {
        System.out.println("##### Running CanAddCustomer #####");

        /*
        The text “Add New Customer” must be present in the form;
        */

        driver.findElement(By.linkText("New Customer")).click();

        Assert.assertEquals(true, driver.findElement(By.xpath("//p[contains(text(),\"Add New Customer\")]\t")).isDisplayed());

//            if(driver.findElements(By.xpath("//p[contains(text(),\"Add New Customer\")]\t")).size() != 0){
//                System.out.println("''Add New Customer'' is Present");
//            }else{
//                System.out.println("Element is not present");
//            }

        //driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("useraaaa");

        //driver.findElement(By.id("dob")).click();#################################################################
        driver.findElement(By.id("dob")).sendKeys(Keys.UP);

        //driver.findElement(By.name("addr")).click();
        driver.findElement(By.name("addr")).sendKeys("asdfasdf");

        driver.findElement(By.cssSelector("tr:nth-child(8) > td:nth-child(1)")).click();
        //driver.findElement(By.name("city")).click();

        driver.findElement(By.name("city")).sendKeys("asdf");

        driver.findElement(By.name("state")).sendKeys("asdf");

        driver.findElement(By.name("pinno")).sendKeys("123456123");

        driver.findElement(By.name("telephoneno")).sendKeys("123456132");

        driver.findElement(By.name("emailid")).sendKeys("useralf@liferay.com");

        driver.findElement(By.name("password")).sendKeys("1234563123");

        //driver.findElement(By.cssSelector(".heading3")).click();

        driver.findElement(By.name("sub")).click();
        //driver.findElement(By.cssSelector("#customer tr:nth-child(1) > td")).click();

        Assert.assertEquals(true, driver.findElement(By.xpath("//p[@class='heading3'][contains(text(),\"Customer Registered Successfully!!!\")]\t")).isDisplayed());
    }

    @Test
    public void AssertAllFieldsAreMandatory() {

        driver.findElement(By.linkText("New Customer")).click();

        //Assert customer name must not be blank.
        driver.findElement(By.name("name")).sendKeys(Keys.TAB);
        Assert.assertEquals(true, driver.findElement(By.xpath("//label[@id='message']")).isDisplayed());

        //######### Gender shows no message, a bug?
        driver.findElement(By.xpath("//input[@value='m']")).sendKeys(Keys.TAB);

        //Assert date Field must not be blank.
        Assert.assertEquals(true, driver.findElement(By.xpath("//label[@id='message24']")).isDisplayed());

        //Assert address Field must not be blank.
        driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(Keys.TAB);
        Assert.assertEquals(true, driver.findElement(By.xpath("//label[@id='message3']")).isDisplayed());

        //Assert city Field must not be blank.
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(Keys.TAB);
        Assert.assertEquals(true, driver.findElement(By.xpath("//label[@id='message4']")).isDisplayed());

        //Assert state must not be blank.
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys(Keys.TAB);
        Assert.assertEquals(true, driver.findElement(By.xpath("//label[@id='message5']")).isDisplayed());

        //Assert PIN Code must not be blank.
        driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(Keys.TAB);
        Assert.assertEquals(true, driver.findElement(By.xpath("//label[@id='message6']")).isDisplayed());

        //Assert mobile no must not be blank.
        driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(Keys.TAB);
        Assert.assertEquals(true, driver.findElement(By.xpath("//label[@id='message7']")).isDisplayed());

        //Assert email-ID must not be blank.
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(Keys.TAB);
        Assert.assertEquals(true, driver.findElement(By.xpath("//label[@id='message9']")).isDisplayed());


        //Assert password must not be blank.
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Keys.TAB);
        Assert.assertEquals(true, driver.findElement(By.xpath("//label[@id='message18']")).isDisplayed());




    }
}