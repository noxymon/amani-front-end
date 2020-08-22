package id.akademi.amanifo.course.services;

import id.akademi.amanifo.course.services.models.JoinCourseParam;
import id.akademi.amanifo.course.services.models.JoinCourseResult;

public interface IJoinCourse {
    JoinCourseResult doJoin(JoinCourseParam joinCourseParam);
}