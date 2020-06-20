package id.akademi.amanifo.course.services;

import id.akademi.amanifo.course.services.models.CourseResult;
import id.akademi.amanifo.course.services.models.CourseResultList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class FetchCoursesApi implements IFetchCourses
{
    private final RestTemplate restTemplate;

    @Value("${api.course.url}")
    private String courseApiUrl;

    public CourseResultList all()
    {
        URI uri = buildUriWithPath("/");
        return restTemplate.getForObject(uri, CourseResultList.class);
    }

    public CourseResult byId(String id)
    {
        URI uri = buildUriWithPath("/" + id);
        return restTemplate.getForObject(uri, CourseResult.class);
    }

    private URI buildUriWithPath(String path)
    {
        return UriComponentsBuilder.fromUriString(courseApiUrl)
                                   .path(path)
                                   .build()
                                   .toUri();
    }
}
