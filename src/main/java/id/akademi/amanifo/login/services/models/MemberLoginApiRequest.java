package id.akademi.amanifo.login.services.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberLoginApiRequest {
    private final String email;
    private final String password;
}