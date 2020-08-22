package id.akademi.amanifo.course.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import id.akademi.amanifo.course.services.models.JoinCourseApiRequest;
import id.akademi.amanifo.course.services.models.JoinCourseApiResponse;
import id.akademi.amanifo.course.services.models.JoinCourseParam;
import id.akademi.amanifo.course.services.models.JoinCourseResult;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinCourseByApi implements IJoinCourse
{
    @Value("${api.course.url}")
    private String joinCourseUrl;

    private final RestTemplate restTemplate;

    @Override
    public JoinCourseResult doJoin(JoinCourseParam joinCourseParam)
    {
        URI uriFromParam = buildUriFromParam(joinCourseParam);
        JoinCourseApiRequest apiRequest = buildJoinCourseApiRequest(joinCourseParam);

        JoinCourseApiResponse responseFromApi = getResponseFromApi(uriFromParam, apiRequest);

        return JoinCourseResult
          .builder()
          .transactionId(responseFromApi.getTranscationId())
          .build();
    }

    private JoinCourseApiRequest buildJoinCourseApiRequest(JoinCourseParam joinCourseParam)
    {
        return JoinCourseApiRequest
          .builder()
          .memberId(joinCourseParam.getMemberId())
          .build();
    }

    private JoinCourseApiResponse getResponseFromApi(URI uriFromParam, JoinCourseApiRequest apiRequest)
    {
        return restTemplate.postForObject(uriFromParam, apiRequest, JoinCourseApiResponse.class);
    }

    private URI buildUriFromParam(JoinCourseParam joinCourseParam)
    {
        return UriComponentsBuilder
          .fromUriString(joinCourseUrl)
          .path("/" + joinCourseParam.getCourseId() + "/join")
          .build()
          .toUri();
    }
}
