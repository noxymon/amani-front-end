package id.akademi.amanifo.course.services.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignatureResponse {
    private String apiKey;
    private String signature;
    private Integer role;
    private String passcode;
}