package id.akademi.amanifo.home.services;

import id.akademi.amanifo.course.services.IFetchCourses;
import id.akademi.amanifo.course.services.models.CourseResultList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceByCallFunction implements ICourseService
{
    private final IFetchCourses courseService;

    @Override
    public CourseResultList fetchAllCourses()
    {
        return courseService.all();
    }
}
