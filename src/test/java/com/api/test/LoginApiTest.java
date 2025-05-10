package com.api.test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginApiTest {

    @Test(description="Verify if login API working")
    public void loginTest(){
        Response response = given()
                .baseUri("http://64.227.160.186:8080")
                .header("Content-Type","application/Json")
                .body("{\"username\": \"hatendra\",\"password\": \"Welcome@123\" }")
                .post("/api/auth/login");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
