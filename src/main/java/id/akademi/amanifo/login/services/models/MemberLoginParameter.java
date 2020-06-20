package id.akademi.amanifo.login.services.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberLoginParameter {
    private String email;
    private String password;
}
