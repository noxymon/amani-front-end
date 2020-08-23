package id.akademi.amanifo.registration.services.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberRegisterResult
{
    private String  id;
    private String  email;
    private boolean active;
    private String  lastName;
    private String  firstName;
}
