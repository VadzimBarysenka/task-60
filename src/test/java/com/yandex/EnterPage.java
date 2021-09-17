package com.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnterPage {
    private final WebDriver driver;
    private static final String URL = "https://mail.yandex.com/";
    private By enterButton = By.xpath("//a[contains(@class, \"HeadBanner-Button-Enter\")]");

    public EnterPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL);
    }

    public LoginPage enterToLoginPage() {
        WebElement enter = driver.findElement(enterButton);
        enter.click();
        return new LoginPage(driver);
    }
}

