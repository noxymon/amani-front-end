package id.akademi.amanifo.registration.services.models;

import java.time.LocalDate;
import id.akademi.amanifo.registration.utils.MemberType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberRegisterBackendRequest
{
    private String    email;
    private String    lastName;
    private String    password;
    private String    firstName;
    private LocalDate dateOfBirth;
    @Builder.Default
    private String    memberType = MemberType.REGULER.getMemberTypeId();
}
