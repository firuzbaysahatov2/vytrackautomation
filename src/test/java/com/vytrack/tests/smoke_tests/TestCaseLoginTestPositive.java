package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.SeleniumUtils;
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

public class TestCaseLoginTestPositive {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //driver setup
        WebDriverManager.chromedriver().setup();
        //to initialize driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
     //   VYTrackUtils.login(driver, "storemanager216", "UserUser123");
        //  String username= "user183";
        // String password= "UserUser123";
        //storemanager216
        //salesmanager279

        }
    @Test
    public void test1() {
        VYTrackUtils.login(driver, "salesmanager279", "UserUser123");
        WebElement managername= driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[1]"));
        Assert.assertTrue(managername.getText().equals("Frankie Schneider"));
        WebElement dashboardelement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
        Assert.assertTrue(dashboardelement.getText().equals("Dashboard"));
       driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[1]")).click();
       driver.findElement(By.xpath("//*[@class='no-hash']")).click();
    }

    @Test
    public void test2(){
        VYTrackUtils.login(driver, "storemanager216", "UserUser123");
        WebElement storemanagername= driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[1]"));
        Assert.assertTrue(storemanagername.getText().equals("Scot Ritchie"));
        WebElement dashboardelement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
        Assert.assertTrue(dashboardelement.getText().equals("Dashboard"));
        driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[1]")).click();
        driver.findElement(By.xpath("//*[@class='no-hash']")).click();
    }
    @Test
    public void test3(){
        VYTrackUtils.login(driver, "user183", "UserUser123");
        WebElement storemanagername= driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[1]"));
        Assert.assertTrue(storemanagername.getText().equals("Scot Ritchie"));
        WebElement dashboardelement=driver.findElement(By.xpath("//*[@class='oro-subtitle']"));
        Assert.assertTrue(dashboardelement.getText().equals("Dashboard"));
        driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[1]")).click();
        driver.findElement(By.xpath("//*[@class='no-hash']")).click();
    }

}