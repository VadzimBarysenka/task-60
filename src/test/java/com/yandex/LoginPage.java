package com.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    private final By userNameField = By.id("passp-field-login");
    private final By userPasswordField = By.id("passp-field-passwd");
    private final By loginButton = By.id("passp:sign-in");

    public LoginPage() {
        this.driver = WebDriverSingleton.getInstance().getDriver();
    }

    public MailPage loginToMail(String name, String password) {
        WebElement nameField = driver.findElement(userNameField);
        WebElement logButton = driver.findElement(loginButton);
        nameField.sendKeys(name);
        logButton.click();
        WebElement passwordField = driver.findElement(userPasswordField);
        passwordField.sendKeys(password);
        WebElement signInButton = driver.findElement(loginButton);
        signInButton.click();
        return new MailPage();
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }
}
