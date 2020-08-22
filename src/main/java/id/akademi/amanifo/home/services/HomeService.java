package id.akademi.amanifo.home.services;

import java.util.List;
import org.springframework.stereotype.Service;
import id.akademi.amanifo.course.services.models.CourseResult;
import id.akademi.amanifo.home.services.models.HomeItem;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeService
{
    private final ICourseService courseService;

    public HomeItem build()
    {
        final List<CourseResult> courseResultList = courseService.fetchAllCourses()
                                                                 .getCourseResponseList();
        return HomeItem.builder()
                       .courseResultList(courseResultList)
                       .build();
    }
}
