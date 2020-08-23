package id.akademi.amanifo.login.controllers.models;

import id.akademi.amanifo.login.services.models.MemberLoginResult;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class LoginResponse implements Serializable
{
    private static final long serialVersionUID = 6343139073514521287L;

    private String            id;
    private String            email;
    private String            firstName;
    private String            lastName;
    private String            memberType;

    public static LoginResponse from(MemberLoginResult memberLoginResult)
    {
        return LoginResponse.builder()
                            .id(memberLoginResult.getId())
                            .email(memberLoginResult.getEmail())
                            .firstName(memberLoginResult.getFirstName())
                            .lastName(memberLoginResult.getLastName())
                            .memberType(memberLoginResult.getMemberType())
                            .build();
    };
}
