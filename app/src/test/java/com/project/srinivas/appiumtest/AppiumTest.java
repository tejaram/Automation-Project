package com.project.srinivas.appiumtest;

/**
 * Created by srinivas on 26-04-2017.
 */

import java.net.MalformedURLException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.*;
import io.appium.java_client.android.*;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.*;
import java.net.URL;
import java.util.*;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

import static android.R.attr.id;


public class AppiumTest {

    private WebDriver driver;





    @Before
    public void setUp() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "emulator-5554");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, "5.1.1");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is
        // com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "com.groupon");

        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "com.groupon.activity.Carousel");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);




    }

    @Test
    public void testFlow() {


        WebDriverWait wait = new WebDriverWait(driver, 30);

        //Click search
        //driver.findElement(By.id("com.groupon:id/action_bar_search_edittext")).click();


        //driver.findElement(By.id("com.groupon:id/continue_step")).click();//Tejaram
        //driver.findElement(By.id("com.groupon:id/continue_step")).click();//Tejaram
        //driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();
        //driver.findElement(By.id("com.groupon:id/in_app_messages_icon")).click();//Tejaram

        //driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_or")).click();
        //Enter City name

        driver.findElement(By.id("com.groupon:id/action_bar_search_edittext")).sendKeys("San Jose");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        //Select city
        driver.findElement(By.xpath("//android.widget.TextView[@text='San Jose, CA']")).click();

        //Select continue
        driver.findElement(By.id("com.groupon:id/continue_step")).click();

        driver.findElement(By.id("com.groupon:id/skip_onboarding")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.groupon:id/global_search_button_text")));


        //Search Groupon click
        driver.findElement(By.id("com.groupon:id/global_search_button_text")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.groupon:id/search_edittext")));



        //search for samsung s7
        driver.findElement(By.id("com.groupon:id/search_edittext")).sendKeys("samsung galaxy s7");
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.TextView[@text='samsung galaxy s7']")));



        //click on preffered suggestion
        driver.findElement(By.xpath("//android.widget.TextView[@text='samsung galaxy s7']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.FrameLayout[@index='0']")));

        //select required item
        driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']")).click();


        //
        driver.findElement(By.xpath("//android.widget.TextView[@text='Samsung Galaxy US Unlocked Phones: J3/Black']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.groupon:id/buy_button")));

        //click buy
        driver.findElement(By.id("com.groupon:id/buy_button")).click();

        //click new user
        driver.findElement(By.xpath("//android.widget.TextView[@text='New User']")).click();

        //enter the details
        //change email and username every time you run
        driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_name")).sendKeys("Chinnu chinn3");
        driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_email")).sendKeys("email52@123.com");
        driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_password")).sendKeys("abc0123a");
        driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_groupon_button")).click();

        //accept terms
        driver.findElement(By.id("com.groupon:id/fragment_terms_conditions_submit")).click();

        //click back to home page
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.name("Navigate up")).click();

        //account menu
        driver.findElement(By.id("com.groupon:id/expand_account_box_indicator_group")).click();

        //account singout
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")).click();




    }


    @Test
    public void testFlow1() {


        WebDriverWait wait = new WebDriverWait(driver, 30);

        //Click search
        //driver.findElement(By.id("com.groupon:id/action_bar_search_edittext")).click();
        /*driver.findElement(By.id("com.groupon:id/continue_step")).click();//Tejaram
        driver.findElement(By.id("com.groupon:id/continue_step")).click();//Tejaram
        driver.findElement(By.xpath("//android.widget.Button[@index='2']")).click();*/
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //driver.findElement(By.id("com.groupon:id/in_app_messages_indicator")).click();//Tejaram
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.id("com.groupon:id/action_bar_search_edittext")).sendKeys("San Jose");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        //Select city
        driver.findElement(By.xpath("//android.widget.TextView[@text='San Jose, CA']")).click();
        //Select continue
        driver.findElement(By.id("com.groupon:id/continue_step")).click();
        driver.findElement(By.id("com.groupon:id/skip_onboarding")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.groupon:id/global_search_button_text")));


        //Search Groupon click
        driver.findElement(By.id("com.groupon:id/global_search_button_text")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.groupon:id/search_edittext")));
        //search for samsung s7
        driver.findElement(By.id("com.groupon:id/search_edittext")).sendKeys("Google Pixel");
        //wait.until(ExpectedConditions.presenceOfElementLocated(By
          //      .xpath("//android.widget.TextView[@text='samsung galaxy s7']")));
        //click on preffered suggestion
        driver.findElement(By.xpath("//android.widget.TextView[@text='google pixel charger']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.FrameLayout[@index='0']")));
        driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']")).click();


        //
        //driver.findElement(By.xpath("//android.widget.TextView[@text='Samsung Galaxy US Unlocked Phones: J3/Black']")).click();
        driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.groupon:id/buy_button")));

        //click buy
        driver.findElement(By.id("com.groupon:id/buy_button")).click();

        //click new user
        driver.findElement(By.xpath("//android.widget.TextView[@text='New User']")).click();
        driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_name")).sendKeys("teja ram");
        driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_email")).sendKeys("tejaram@gmail.com");
        driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_password")).sendKeys("Teja@1297");
        driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_groupon_button")).click();
        driver.findElement(By.id("com.groupon:id/fragment_terms_conditions_submit")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
        //enter the details
        //change email and username every time you run
        /*WebElement accEle = driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_email"));
        accEle.clear();
        accEle.sendKeys("tejaram@gmail.com");
        WebElement pwdEle = driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_password"));
        pwdEle.clear();
        pwdEle.sendKeys("Teja@1297");
        driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_groupon_button")).click();*/

        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        //driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.id("com.groupon:id/shopping_cart")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();

        driver.findElement(By.id("com.groupon:id/global_search_button_text")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.groupon:id/search_edittext")));
        //search for samsung s7
        driver.findElement(By.id("com.groupon:id/search_edittext")).sendKeys("Google Pixel");
        //wait.until(ExpectedConditions.presenceOfElementLocated(By
        //      .xpath("//android.widget.TextView[@text='samsung galaxy s7']")));
        //click on preffered suggestion
        driver.findElement(By.xpath("//android.widget.TextView[@text='google pixel charger']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//android.widget.FrameLayout[@index='0']")));
        driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']")).click();


        //
        //driver.findElement(By.xpath("//android.widget.TextView[@text='Samsung Galaxy US Unlocked Phones: J3/Black']")).click();
        driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .id("com.groupon:id/buy_button")));

        //click buy
        driver.findElement(By.id("com.groupon:id/buy_button")).click();
        WebElement accEle = driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_email"));
        accEle.clear();
        accEle.sendKeys("tejaram@gmail.com");
        WebElement pwdEle = driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_password"));
        pwdEle.clear();
        pwdEle.sendKeys("Teja@1297");
        driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_groupon_button")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.id("com.groupon:id/shopping_cart")).click();
        /*WebElement noItems = driver.findElement(By.xpath("//android.widget.TextView[@text='Continue Shopping']"));
        Assert.assertTrue(noItems.isDisplayed());
        //WebElement myAccount = driver.findElement(By.xpath(".//*[@id='account']/a"));
        driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
        driver.findElement(By.id("com.groupon:id/positive_button")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.name("Navigate up")).click();*/
        //driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_name")).sendKeys("Chinnu chinn3");
        //driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_email")).sendKeys("email52@123.com");
        //driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_password")).sendKeys("abc0123a");
        //driver.findElement(By.id("com.groupon:id/fragment_log_in_sign_up_groupon_button")).click();

        //accept terms
        //driver.findElement(By.id("com.groupon:id/fragment_terms_conditions_submit")).click();

        //click back to home page
        /*driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
        driver.findElement(By.name("Navigate up")).click();*/

        //account menu
        //driver.findElement(By.id("com.groupon:id/expand_account_box_indicator_group")).click();

        //account singout
        //driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")).click();

    }



    @After
    public void End() {
        driver.quit();
    }
}