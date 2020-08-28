package id.akademi.amanifo.course.services;

import id.akademi.amanifo.course.services.models.CourseResult;
import id.akademi.amanifo.course.services.models.CourseResultList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        final CourseResultList resultList = restTemplate.getForObject(uri, CourseResultList.class);
        final List<CourseResult> courseResultListWithImage = composeImageWithFloor(resultList);
        return new CourseResultList(courseResultListWithImage);
    }

    private List<CourseResult> composeImageWithFloor(CourseResultList resultList)
    {
        final List<CourseResult> courseResultListWithImage = resultList
          .getCourseResponseList()
          .parallelStream()
          .map(courseResult -> {
              CourseResult courseResultWithImage = new CourseResult(courseResult);
              courseResultWithImage.setFloorImage(generateFloorImage());
              return courseResultWithImage;
          })
          .collect(Collectors.toList());
        return courseResultListWithImage;
    }

    public CourseResult byId(String id)
    {
        URI uri = buildUriWithPath("/" + id);
        CourseResult courseResult = restTemplate.getForObject(uri, CourseResult.class);
        courseResult.setCourseDetailImage(generateRandomDetailImage());
        courseResult.setFloorImage(generateFloorImage());
        return courseResult;
    }

    private String generateRandomDetailImage()
    {
        return "cd_display_" + new Random().nextInt(5) + ".jpeg";
    }

    private String generateFloorImage()
    {
        return "hp_display_" + new Random().nextInt(5) + ".jpeg";
    }

    private URI buildUriWithPath(String path)
    {
        return UriComponentsBuilder
          .fromUriString(courseApiUrl)
          .path(path)
          .build()
          .toUri();
    }

    @Override
    public CourseResult byIdAndMember(String courseId, String memberId)
    {
        URI uri = buildUriWithPath("/" + courseId + "/" + memberId);
        return restTemplate.getForObject(uri, CourseResult.class);
    }
}
