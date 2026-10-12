package com.ccst.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    private static final Logger log = LogManager.getLogger(BaseTest.class);
    
    @BeforeMethod
    public void _setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            log.info("Browser initialized and window maximized");
    }
    
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            log.info("Closing the browser");
            driver.quit();
        }
    }
}
