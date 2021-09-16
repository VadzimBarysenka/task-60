package com.yandex;

import org.junit.jupiter.api.*;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private final String USER_NAME = "someuserfortest";
    private final String USER_PASSWORD = "!QAZxsw2";

    @BeforeEach
    public void setup() {
        WebDriverSingleton.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverSingleton.getInstance().manage().window().maximize();
    }

    @AfterEach
    public void cleanup() {
        WebDriverSingleton.getInstance().close();
    }

    @Test
    public void login() {
        EnterPage enter = new EnterPage(WebDriverSingleton.getInstance());
        LoginPage loginPage = enter.enterToLoginPage();
        MailPage mailPage = loginPage.loginToMail(USER_NAME, USER_PASSWORD);

        assertEquals(USER_NAME, mailPage.getUserName());
    }
}