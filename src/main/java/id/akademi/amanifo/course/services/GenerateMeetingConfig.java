package id.akademi.amanifo.course.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.akademi.amanifo.course.services.models.MeetingConfig;
import id.akademi.amanifo.course.services.models.SignatureResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenerateMeetingConfig
{

    @Value("${api.course.signature.url}")
    private String             signatureGeneratorUrl;

    @Value("${apps.base-url}")
    private String             baseUrl;

    private final RestTemplate restTemplate;

    public MeetingConfig generate(String meetingNumber)
    {
        SignatureResponse generatedSignature = restTemplate.getForObject(
            signatureGeneratorUrl + "/" + meetingNumber,
            SignatureResponse.class
        );
        return MeetingConfig.builder()
                            .signature(generatedSignature.getSignature())
                            .password(generatedSignature.getPasscode())
                            .apiKey(generatedSignature.getApiKey())
                            .role(generatedSignature.getRole())
                            .leaveUrl("https://google.com")
                            .meetingNumber(meetingNumber)
                            .baseUrl(baseUrl)
                            .build();
    };
}
