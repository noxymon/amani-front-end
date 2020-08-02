package id.akademi.amanifo.registration.services.models;

import java.time.LocalDateTime;
import java.util.UUID;
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
