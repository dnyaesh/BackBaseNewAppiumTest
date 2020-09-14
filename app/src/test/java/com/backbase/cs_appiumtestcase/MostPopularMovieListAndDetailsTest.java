package com.backbase.cs_appiumtestcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MostPopularMovieListAndDetailsTest
{
    AppiumDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUp() throws MalformedURLException
    {
        DesiredCapabilities cap = Helper.getCapabilities();

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        wait = new WebDriverWait(driver, 20);
    }

    // Here I have written Appium automation test cases for "Most-Popular" movie list, It's item click, Details page
    // and back to Home activity
    @Test
    public void testMostPopularMovieListAndDetailsPage()
    {
        try
        {
            // Wait until Playing Now movie list is not visible
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id(TestConstants.PACKAGE_NAME+":id/rvMostPopularMovies")));

            Thread.sleep(5000); // Explicit Delay

            // Get all displayed items from Playing-Now list
            java.util.List <WebElement> mostPopularMovieList= driver.findElements(By.xpath("//android.widget.RelativeLayout[@resource-id='com.backbase.assignment:id/rlPopularMoviesParent']"));

            if(mostPopularMovieList!=null && mostPopularMovieList.size()>0)
            {
                // Click first item in the "Most-Popular" list
                mostPopularMovieList.get(0).click();

                // Wait until Details page is not visible
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id(TestConstants.PACKAGE_NAME+":id/ivPoster")));

                Thread.sleep(5000); // Explicit Delay

                // Perform click on BackButton on Details page and Go Back to the Home Activity
                wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.id(TestConstants.PACKAGE_NAME+":id/ivBack"))).click();

                Thread.sleep(2000); // Explicit Delay

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @After
    public void End() {
        driver.quit();
    }
}
