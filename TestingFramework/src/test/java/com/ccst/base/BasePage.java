package com.ccst.base;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public abstract class BasePage implements Page {

    protected final Logger log= LogManager.getLogger(getClass());
    public WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
    }

    protected void click(By locator)
    {
        driver.findElement(locator).click();
    }

    protected void enterText(By locator, String text)
    {
        driver.findElement(locator).sendKeys(text);
    }

    protected boolean validateContent(By locator, String text)
    {
        return driver.findElement(locator).getText().equals(text);
    }
}
