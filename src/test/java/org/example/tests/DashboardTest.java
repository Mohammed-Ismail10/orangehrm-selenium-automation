package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void dashboardTestSetUp() {

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Parameters({"username", "password"})
    @Test(groups = {"smoke", "dashboard"})
    public void verifyDashboardAfterLogin(String username, String password) {

        loginPage.login(
                username,
                password
        );

        Assert.assertEquals(
                dashboardPage.getDashboardTitle(),
                "Dashboard"
        );
    }

    @Parameters({"username", "password"})
    @Test(groups = {"smoke", "dashboard"})
    public void verifyTimeAtWorkSection(String username, String password) {

        loginPage.login(
                username,
                password
        );

        Assert.assertEquals(
                dashboardPage.getTimeAtWorkText(),
                "Time at Work"
        );
    }

}