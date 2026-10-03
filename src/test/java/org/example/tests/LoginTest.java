package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void loginTestSetUp() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Parameters({"username", "password"})
    @Test(groups = {"smoke", "login"})
    public void validLoginTest(String username, String password) {
        loginPage.login(
                username,
                password
        );

        Assert.assertEquals(
                dashboardPage.getDashboardTitle(),
                "Dashboard"
        );
    }

    @Test(groups = {"regression", "login"})
    public void invalidLoginTest() {

        loginPage.login("Admin", "wrongPassword");

        Assert.assertEquals(
                loginPage.getErrorCredentialsText(),
                "Invalid credentials"
        );
    }


    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][]{
                {"Admin", "admin123", true},
                {"Admin", "wrongPassword", false},
                {"Admin", "123456", false}
        };
    }

    @Test(
            dataProvider = "loginData",
            groups = {"regression", "login"}
    )
    public void loginWithMultipleDataTest(
            String username,
            String password,
            boolean shouldLoginSuccessfully) {

        loginPage.login(username, password);

        if (shouldLoginSuccessfully) {

            Assert.assertEquals(
                    dashboardPage.getDashboardTitle(),
                    "Dashboard"
            );

        } else {

            Assert.assertEquals(
                    loginPage.getErrorCredentialsText(),
                    "Invalid credentials"
            );
        }
    }













}