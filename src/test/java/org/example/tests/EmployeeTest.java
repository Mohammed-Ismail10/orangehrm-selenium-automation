package org.example.tests;

import org.example.base.BaseTest;
import org.example.pages.EmployeePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseTest {

    LoginPage loginPage;
    EmployeePage employeePage;

    @Parameters({"username", "password"})
    @BeforeMethod(alwaysRun = true)
    public void employeeTestSetUp(String username, String password) {
        loginPage = new LoginPage(driver);
        employeePage = new EmployeePage(driver);
        loginPage.login(username, password);
    }


    @DataProvider(name = "employeeData")
    public Object[][] employeeData() {

        return new Object[][]{
                {"Mohammed", "Abdullah", "Ismail"},
                {"Ahmed", "Ali", "Hassan"},
                {"Omar", "Mohamed", "Test"}
        };
    }

    @Test(
            dataProvider = "employeeData",
            groups = {"regression", "employee"}
    )
    public void verifyAddEmployee(
            String firstName,
            String middleName,
            String lastName) {


        employeePage.clickPIM();

        employeePage.clickAdd();

        employeePage.addEmployee(
                firstName,
                middleName,
                lastName
        );

        employeePage.clickSave();

        Assert.assertTrue(
                employeePage.getSuccessMessage()
                        .contains("Successfully Saved")
        );
    }


    @Test(groups = {"regression", "employee"})
    public void verifyAddEmployeePage() {

        employeePage.clickPIM();

        employeePage.clickAdd();

        Assert.assertEquals(
                employeePage.getAddEmployeeTitle(),
                "Add Employee"
        );
    }


    @Test(
            groups = {"regression", "employee"},
            dependsOnMethods = {"verifyAddEmployeePage"}
    )
    public void verifyAddEmployeeForm() {

        employeePage.clickPIM();

        employeePage.clickAdd();

        employeePage.addEmployee(
                "Mohammed",
                "Abdullah",
                "Ismail"
        );

        employeePage.clickSave();

        Assert.assertTrue(
                employeePage.getSuccessMessage()
                        .contains("Successfully Saved")
        );
    }
}
