package id.akademi.amanifo.login.controllers.models;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}