package org.example.tests;

import org.example.api.EmployeeApi;
import org.example.base.ApiBaseTest;
import org.testng.Assert;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class EmployeeApiTest extends ApiBaseTest {

    @Test
    public void getEmployeeTest() {

        EmployeeApi employeeApi = new EmployeeApi();

        Response response =
                employeeApi.getEmployee(token, 1);

        Assert.assertEquals(
                response.statusCode(),
                200
        );

        Assert.assertEquals(
                response.jsonPath().getInt("data.empNumber"),
                1
        );

        Assert.assertEquals(
                response.jsonPath().getString("data.firstName"),
                "Orange"
        );

        Assert.assertEquals(
                response.jsonPath().getString("data.lastName"),
                "Test"
        );
    }

    @Test
    public void getEmployeesTest() {

        EmployeeApi employeeApi = new EmployeeApi();

        Response response =
                employeeApi.getEmployees(token);

        Assert.assertEquals(
                response.statusCode(),
                200
        );
    }
}