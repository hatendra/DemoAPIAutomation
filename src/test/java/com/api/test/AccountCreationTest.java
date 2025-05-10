package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "create account test")
    public void createAccountTest(){
        SignUpRequest signUpRequest= new SignUpRequest.Builder()
                .username("hats")
                .password("123456")
                .email("hatendra1@gmail.com")
                .firstName("hat1")
                .lastName("kumar")
                .mobileNumber("9876541212").build();
        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
    }
}
