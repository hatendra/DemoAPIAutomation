package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest1 {

    @Test(description = "check login test")
    public void loginTest(){
        LoginRequest loginRequest= new LoginRequest("hatendra","Welcome@123");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse= response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.toString());
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertTrue(loginResponse.getToken()  != null);
        Assert.assertEquals(loginResponse.getEmail(),"hatendra@gmail.com");
    }
}
