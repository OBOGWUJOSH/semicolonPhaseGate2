package com.semicolon.africa.notemanagementsystem.dto.request;

import com.semicolon.africa.notemanagementsystem.utilities.Quotes;
import lombok.Getter;
import lombok.Setter;

import java.awt.geom.QuadCurve2D;
import java.util.List;

@Getter
@Setter
public class LogoutUserRequest {
    private String userName;
    private String Email;
    private List <Quotes> quotes; // Why do you want to log out

}
