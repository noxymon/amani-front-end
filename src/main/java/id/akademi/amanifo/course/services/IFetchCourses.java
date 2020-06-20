package id.akademi.amanifo.course.services;

import id.akademi.amanifo.course.services.models.CourseResult;
import id.akademi.amanifo.course.services.models.CourseResultList;

public interface IFetchCourses
{
    CourseResultList all();
    CourseResult byId(String id);
}
