package org.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EmployeeApi {

    public Response getEmployee(String token, int employeeNumber) {

        return RestAssured
                .given()
                .auth()
                .oauth2(token)
                .when()
                .get("/pim/employees/", employeeNumber)
                .then()
                .extract()
                .response();
    }

    public Response getEmployees(String token) {

        return RestAssured
                .given()
                .auth()
                .oauth2(token)
                .when()
                .get("/pim/employees")
                .then()
                .extract()
                .response();
    }
}