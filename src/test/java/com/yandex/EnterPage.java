package com.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterPage {
    private final WebDriver driver;
    private static final String URL = "https://mail.yandex.com/";

    @FindBy(xpath = "//a[contains(@class, \"HeadBanner-Button-Enter\")]")
    private WebElement enterButton;

    public EnterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(URL);
    }

    public LoginPage enterToLoginPage() {
        enterButton.click();
        return new LoginPage(driver);
    }
}