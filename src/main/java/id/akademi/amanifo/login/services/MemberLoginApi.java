package id.akademi.amanifo.login.services;

import id.akademi.amanifo.login.services.models.MemberLoginApiRequest;
import id.akademi.amanifo.login.services.models.MemberLoginParameter;
import id.akademi.amanifo.login.services.models.MemberLoginResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class MemberLoginApi implements IMemberLogin
{
    @Value("${api.member.url}")
    private String memberApiUrl;

    private final RestTemplate restTemplate;

    @Override
    public MemberLoginResult login(MemberLoginParameter memberLoginParameter)
    {
        URI memberLoginURI = buildMemberLoginUri("/auth");
        MemberLoginApiRequest loginApiRequest = buildMemberLoginRequest(memberLoginParameter);
        return restTemplate.postForObject(memberLoginURI, loginApiRequest, MemberLoginResult.class);
    }

    private MemberLoginApiRequest buildMemberLoginRequest(MemberLoginParameter memberLoginParameter)
    {
        MemberLoginApiRequest loginApiRequest = MemberLoginApiRequest.builder()
                                                                     .email(memberLoginParameter.getEmail())
                                                                     .password(memberLoginParameter.getPassword())
                                                                     .build();
        return loginApiRequest;
    }

    private URI buildMemberLoginUri(String path)
    {
        URI memberLoginURI = UriComponentsBuilder
                .fromUriString(memberApiUrl)
                .path(path)
                .build()
                .toUri();
        return memberLoginURI;
    }

    ;
}