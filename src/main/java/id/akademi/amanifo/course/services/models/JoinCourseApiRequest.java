package id.akademi.amanifo.course.services.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JoinCourseApiRequest {
    private String memberId;
}