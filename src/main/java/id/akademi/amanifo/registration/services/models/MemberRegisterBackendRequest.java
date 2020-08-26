package id.akademi.amanifo.registration.services.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @Builder.Default
    private String    memberType = MemberType.REGULER.getMemberTypeId();
}
