package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagement;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test
    public void  updateProfile(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("hatendra", "Welcome@123"));
        LoginResponse loginResponse= response.as(LoginResponse.class);
        //System.out.println(loginResponse.getToken());

        UserProfileManagement userProfileManagement = new UserProfileManagement();
        response = userProfileManagement.getProfile(loginResponse.getToken());
        UserProfileResponse userProfileResponse= response.as(UserProfileResponse.class);

        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .email("hatendra@gmail.com").firstName("hatendraa").mobileNumber("9876543210").lastName("Singh").build();
        Response response1 = userProfileManagement.updateProfile(loginResponse.getToken(), profileRequest);
        System.out.println(response1.asPrettyString());

    }
}
