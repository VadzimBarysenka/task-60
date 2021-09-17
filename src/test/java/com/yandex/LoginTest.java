package com.yandex;
// user: someuserfortest
// pass: !QAZxsw2
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    WebDriver driver;
    private final String USER_NAME = "someuserfortest";
    private final String USER_PASSWORD = "!QAZxsw2";

    @BeforeEach
    public void setup() {
        driver = WebDriverSingleton.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void cleanup() {
        driver.close();
    }

    @Test
    public void login() {
        EnterPage enter = new EnterPage(driver);
        LoginPage loginPage = enter.enterToLoginPage();
        MailPage mailPage = loginPage.loginToMail(USER_NAME, USER_PASSWORD);

        assertEquals(USER_NAME, mailPage.getUserName());
    }
}
