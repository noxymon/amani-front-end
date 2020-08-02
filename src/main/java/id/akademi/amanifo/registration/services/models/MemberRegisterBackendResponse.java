package id.akademi.amanifo.registration.services.models;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class MemberRegisterBackendResponse
{
    private String    uuid;
    private String    email;
    private String    lastName;
    private String    password;
    private String    firstName;
    private String    memberType;
    private LocalDate dateOfBirth;
}
