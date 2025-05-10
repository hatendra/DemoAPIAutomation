package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgetPasswordTest {

    @Test(description = "forget password test")
    public void forgetPasswordTest(){
        AuthService authService = new AuthService();
        Response response = authService.forgetPassword("hatendra@gmail.com");
        System.out.println(response.asPrettyString());

    }
}
