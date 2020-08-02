package id.akademi.amanifo.registration.controllers.models;

import id.akademi.amanifo.registration.utils.MemberType;
import lombok.Data;

@Data
public class RegisterRequest
{
    private String email;
    private String lastName;
    private String password;
    private String firstName;
    private String dateOfBirth;
    private String memberType = MemberType.REGULER.getMemberTypeId();
}
