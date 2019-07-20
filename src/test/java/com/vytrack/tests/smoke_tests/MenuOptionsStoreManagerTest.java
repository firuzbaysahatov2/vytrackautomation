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

public class MenuOptionsStoreManagerTest {

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
        VYTrackUtils.login(driver, "storemanager216", "UserUser123");
        //  String username= "user183";
        // String password= "UserUser123";
        //storemanager216
        //salesmanager279
    }

    @Test(priority = 1, description = "Fleet->Vehicle")
    public void test1(){
        VYTrackUtils.navigateToModule(driver, "Dashboard", "Dashboard" );
        WebElement dashboardelement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
        Assert.assertTrue(dashboardelement.getText().equals("Dashboard"));

    }
    @Test(priority = 2, description = "Fleet->Vehicles")
    public void test2(){
        VYTrackUtils.navigateToModule(driver, "Fleet", "Vehicle");
        String title= driver.getTitle();
        String expectedtitle="All - Car - Entities - System - Car - Entities - System";
        Assert.assertEquals(expectedtitle, title);
        WebElement carselement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
        Assert.assertTrue(carselement.getText().equals("All Cars"));
    }
    @Test(priority = 3, description = "Customer->Accounts")
    public void test3(){
        VYTrackUtils.navigateToModule(driver, "Customers", "Accounts");
        String expectedtitle="All - Accounts - Customers";
        String title= driver.getTitle();
        Assert.assertEquals(expectedtitle, title);
        WebElement accountselement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
        Assert.assertTrue(accountselement.getText().equals("All Accounts"));

    }
    @Test(priority =4, description = "Customer->Contacts")
    public void test4(){
        VYTrackUtils.navigateToModule(driver, "Customer", "Contact");
        String expectedtitle="All - Contacts - Customers";
        String title= driver.getTitle();
        Assert.assertEquals(expectedtitle, title);
        WebElement contactselement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
        Assert.assertTrue(contactselement.getText().equals("All Contacts"));

    }
    @Test(priority = 5, description = "Sales-Opportunities")
    public void test5(){
        VYTrackUtils.navigateToModule(driver, "Sales", "Opportunities");
        String expectedtitle="Open Opportunities - Opportunities - Sales";
        String title= driver.getTitle();
        WebElement openopportunitieselement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
        Assert.assertTrue(openopportunitieselement.getText().equals("Open Opportunities"));
    }
    @Test(priority = 6, description ="Activities->Calls")
    public void test6(){
        VYTrackUtils.navigateToModule(driver, "Activities", "Calls");

        String expectedtitle="All - Calls - Activities";
        String title= driver.getTitle();
        Assert.assertEquals(expectedtitle, title);
        WebElement activitiescalls=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
        Assert.assertTrue(activitiescalls.getText().equals("All Calls"));
    }
    @Test(priority = 7, description ="Activities->Calendar Events")
    public void test7(){
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar");

        String expectedtitle="All - Calendar Events - Activities";
        String title= driver.getTitle();
        Assert.assertEquals(expectedtitle, title);
        WebElement CalendarEventselement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
        Assert.assertTrue(CalendarEventselement.getText().equals("All Calendar Events"));
    }

}
