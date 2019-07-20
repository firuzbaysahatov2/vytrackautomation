package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuOptionsDriverTest {

        WebDriver driver;



        @BeforeMethod
        public void setup(){
            //driver setup
            WebDriverManager.chromedriver().setup();
            //to initialize driver
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://qa2.vytrack.com/user/login");
            VYTrackUtils.login(driver, "user183", "UserUser123");
          //  String username= "user183";
           // String password= "UserUser123";
        }

        @Test(priority = 1, description = "Fleet->Vehicle")
    public void test1(){
        VYTrackUtils.navigateToModule(driver, "Fleet", "Vehicles" );
        String expectedtitle="Car - Entities - System - Car - Entities - System";
        String title= driver.getTitle();
            Assert.assertEquals(expectedtitle, title);
            WebElement carselement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
            Assert.assertTrue(carselement.getText().equals("Cars"));

       }
        @Test(priority = 2, description = "Customer->Accounts")
    public void test2(){
        VYTrackUtils.navigateToModule(driver, "Customer", "Accounts");
            String expectedtitle="Accounts - Customers";
            String title= driver.getTitle();
            Assert.assertEquals(expectedtitle, title);
            WebElement accountselement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
            Assert.assertTrue(accountselement.getText().equals("Accounts"));

        }
        @Test(priority =3, description = "Customer->Contacts")
    public void test3(){
        VYTrackUtils.navigateToModule(driver, "Customer", "Contact");
            String expectedtitle="Contacts - Customers";
            String title= driver.getTitle();
            Assert.assertEquals(expectedtitle, title);
            WebElement contactselement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
            Assert.assertTrue(contactselement.getText().equals("Contacts"));

        }
        @Test(priority = 4, description ="Activities->Calendar Events")
    public void test4(){
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar");

        String expectedtitle="Calendar Events - Activities";
        String title= driver.getTitle();
        Assert.assertEquals(expectedtitle, title);
            WebElement CalendarEventselement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
            Assert.assertTrue(CalendarEventselement.getText().equals("Calendar Events"));
        }
    }
