package id.akademi.amanifo.login.services.models;

import lombok.Getter;

@Getter
public class MemberLoginResult
{
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String memberType;
}