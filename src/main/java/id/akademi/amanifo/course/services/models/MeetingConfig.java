package id.akademi.amanifo.course.services.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MeetingConfig {
    private String apiKey;
    private String leaveUrl;
    private String username;
    private String userEmail;
    private String password;
    @Builder.Default
    private Integer role = 0;
    private String meetingNumber;
    private String signature;
    @Builder.Default
    private String baseUrl = "http://localhost:8383";
}