package id.akademi.amanifo.home.services;

import id.akademi.amanifo.course.services.models.CourseResult;
import id.akademi.amanifo.course.services.models.CourseResultList;
import id.akademi.amanifo.home.services.models.HomeItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
