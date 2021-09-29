package com.yandex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogOutTest {
    private MailPage mailPage;
    private final static String USER_NAME = "someuserfortest";
    private final static String USER_PASSWORD = "!QAZxsw2";
    private final static String LOGIN_PAGE_TITLE = "Authorization";

    @BeforeEach
    public void setup() {
        EnterPage enter = new EnterPage();
        LoginPage loginPage = enter.enterToLoginPage();
        mailPage = loginPage.loginToMail(USER_NAME, USER_PASSWORD);
    }

    @AfterEach
    public void cleanup() {
        WebDriverSingleton.getInstance().closeDriver();
    }

    @Test
    public void logout() {
        LoginPage afterLogout = mailPage.logout();

        assertEquals(LOGIN_PAGE_TITLE, afterLogout.getLoginPageTitle());
    }
}