package com.yandex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogOutTest {
    private WebDriver driver;
    private MailPage mailPage;
    private final String USER_NAME = "someuserfortest";
    private final String USER_PASSWORD = "!QAZxsw2";
    private final String LOGIN_PAGE_TITLE = "Authorization";

    @BeforeEach
    public void setup() {
        driver = WebDriverSingleton.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        EnterPage enter = new EnterPage();
        LoginPage loginPage = enter.enterToLoginPage();
        mailPage = loginPage.loginToMail(USER_NAME, USER_PASSWORD);
    }

    @AfterEach
    public void cleanup() {
        driver.close();
    }

    @Test
    public void logout() {
        LoginPage afterLogout = mailPage.logout();

        assertEquals(LOGIN_PAGE_TITLE, afterLogout.getLoginPageTitle());
    }
}