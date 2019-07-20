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

public class TestCaseLoginTestNegative {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
    }

    @Test
    public void test1(){
        VYTrackUtils.login(driver, "salesmanager279", "hello");
        WebElement invalidmessage= driver.findElement(By.xpath("//*[@class='alert alert-error']"));
       Assert.assertEquals(invalidmessage.getText(),"Invalid user name or password.");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
//     ;
       // Assert.assertEquals(driver.getTitle(),driver.getCurrentUrl());
    }
    @Test(description = "TEST CASE: Vehicle contracts test store manager")
    public void test2(){
        VYTrackUtils.login(driver, "storemanager216", "UserUser123");
        VYTrackUtils.navigateToModule(driver, "Fleet", "Vehicle Contracts");
        Assert.assertTrue(driver.findElement(By.className("oro-subtitle") ).isDisplayed());




    }
    @Test(description = "TEST CASE: Vehicle contracts test store manager")
    public void test3(){
        VYTrackUtils.login(driver, "user183", "UserUser123");
        VYTrackUtils.navigateToModule(driver, "Fleet", "Vehicle Contracts");
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='message'])[2]")).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.className("oro-subtitle") ).isDisplayed());
//        Assert.assertTrue(dashboardelement.getText().equals("Dashboard"));




    }
}
