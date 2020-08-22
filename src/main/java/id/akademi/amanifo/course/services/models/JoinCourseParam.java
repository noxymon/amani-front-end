package id.akademi.amanifo.course.services.models;

import id.akademi.amanifo.course.controllers.models.JoinCourseRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JoinCourseParam {
    private String memberId;
    private String courseId;
}
