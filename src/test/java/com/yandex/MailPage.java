package com.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {
    private final WebDriver driver;
    private final By userName = By.xpath("//a[contains(@class, \"legouser__current-account\")]/span[@class=\"user-account__name\"]");
    private final By logOut = By.xpath("//a[@aria-label=\"Log out\"]");
    private final By searchField = By.className("search-bubble-list__bubble-wrap");

    public MailPage() {
        this.driver = WebDriverSingleton.getInstance().getDriver();
        new WebDriverWait(this.driver, 5).until(ExpectedConditions.presenceOfElementLocated(searchField));
    }

    public String getUserName() {
        return driver.findElement(userName).getText();
    }

    public LoginPage logout() {
        WebElement nameLink = driver.findElement(userName);
        nameLink.click();
        WebElement logout = driver.findElement(logOut);
        logout.click();
        return new LoginPage();
    }
}
