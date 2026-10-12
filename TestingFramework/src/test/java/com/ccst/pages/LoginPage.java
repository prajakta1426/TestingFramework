package com.ccst.pages;

import com.ccst.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By emailElement = By.cssSelector("[data-qa='login-email']");
    private final By passwordElement = By.cssSelector("[data-qa='login-password']");
    private final By loginButton = By.cssSelector("[data-qa='login-button']");
    private final By loggedInMessage = By.xpath("//a[text()=' Logged in as ']");

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public String url() {
        return "https://automationexercise.com/login";
    }

    @Override
    public boolean isLoaded(){
        return driver.findElement(loginButton).isEnabled();
    }

    public void login(String email, String password)
    {
        enterText(emailElement,email);
        enterText(passwordElement,password);
        click(loginButton);
    }

    public boolean isUserLoggedIn()
    {
        return driver.findElement(loggedInMessage).isDisplayed();
    }
}
