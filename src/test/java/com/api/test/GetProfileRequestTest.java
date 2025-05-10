package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagement;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetProfileRequestTest {

    @Test
    public void getProfileInfo(){
        AuthService authService= new AuthService();
        Response response = authService.login(new LoginRequest("hatendra","Welcome@123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);

       // System.out.println(loginResponse.getToken());
        UserProfileManagement userProfileManagement = new UserProfileManagement();
        Response profile = userProfileManagement.getProfile(loginResponse.getToken());
       // System.out.println(profile.asPrettyString());
        UserProfileResponse userProfileResponse =profile.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getEmail());
    }
}
