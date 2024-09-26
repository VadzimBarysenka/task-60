package com.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnterPage {
    private final WebDriver driver;
    private static final String URL = "https://mail.yandex.com/";
    private final By enterButton = By.xpath("//a[contains(@class, \"HeadBanner-Button-Enter\")]");

    public EnterPage() {
        this.driver = WebDriverSingleton.getInstance().getDriver();
        this.driver.get(URL);
    }

    public LoginPage enterToLoginPage() {
        WebElement enter = driver.findElement(enterButton);
        enter.click();
        return new LoginPage();
    }
}

