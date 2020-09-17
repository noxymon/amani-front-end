package id.akademi.amanifo.course.services;

import id.akademi.amanifo.course.services.models.CourseResult;
import id.akademi.amanifo.course.services.models.CourseResultList;
import org.springframework.cache.annotation.Cacheable;

public interface IFetchCourses
{
    CourseResultList all();

    @Cacheable(cacheNames = "courseResultById")
    CourseResult byId(String id);

    CourseResult byIdAndMember(String courseId, String memberId);
}
