package org.example.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ApiBaseTest {

    protected String token;
    @BeforeClass
    public void setUpAPI() {

        RestAssured.baseURI =
                "https://opensource-demo.orangehrmlive.com";

        RestAssured.basePath =
                "/web/index.php/api/v2";

        token = System.getenv("ORANGEHRM_API_TOKEN");

        if (token == null || token.isEmpty()) {
            throw new IllegalStateException(
                    "ORANGEHRM_API_TOKEN is not set"
            );
        }
    }
}