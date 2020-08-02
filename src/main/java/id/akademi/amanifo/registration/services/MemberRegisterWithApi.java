package id.akademi.amanifo.registration.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.akademi.amanifo.registration.services.models.MemberRegisterBackendRequest;
import id.akademi.amanifo.registration.services.models.MemberRegisterBackendResponse;
import id.akademi.amanifo.registration.services.models.MemberRegisterParam;
import id.akademi.amanifo.registration.services.models.MemberRegisterResult;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberRegisterWithApi implements IMemberRegister
{

    @Value("${api.member.url}")
    private String             registrationMemberUrl;

    private final RestTemplate restTemplate;

    @Override
    public MemberRegisterResult register(MemberRegisterParam memberRegisterParam)
    {
        MemberRegisterBackendRequest memberRegisterBackendRequest =
            buildMemberRegisterBackendRequest(memberRegisterParam);

        final MemberRegisterBackendResponse backendResponse =
            callMemberRegisterBackend(memberRegisterBackendRequest);

        return memberRegisterResult(backendResponse);
    }

    private MemberRegisterResult memberRegisterResult(final MemberRegisterBackendResponse backendResponse)
    {
        return MemberRegisterResult.builder()
            .active(true)
            .id(backendResponse.getUuid())
            .email(backendResponse.getEmail())
            .lastName(backendResponse.getLastName())
            .firstName(backendResponse.getFirstName())
            .build();
    }

    private MemberRegisterBackendRequest buildMemberRegisterBackendRequest(
        MemberRegisterParam memberRegisterParam)
    {
        MemberRegisterBackendRequest memberRegisterBackendRequest = MemberRegisterBackendRequest.builder()
            .email(memberRegisterParam.getEmail())
            .dateOfBirth(memberRegisterParam.getDateOfBirth())
            .firstName(memberRegisterParam.getFirstName())
            .lastName(memberRegisterParam.getLastName())
            .password(memberRegisterParam.getPassword())
            .memberType(memberRegisterParam.getMemberType().getMemberTypeId())
            .build();
        return memberRegisterBackendRequest;
    }

    private MemberRegisterBackendResponse callMemberRegisterBackend(
        MemberRegisterBackendRequest memberRegisterBackendRequest)
    {
        final MemberRegisterBackendResponse backendResponse = restTemplate.postForObject(
            registrationMemberUrl,
            memberRegisterBackendRequest,
            MemberRegisterBackendResponse.class
        );
        return backendResponse;
    }

}
