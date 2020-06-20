package id.akademi.amanifo.home.services.models;

import id.akademi.amanifo.course.services.models.CourseResult;
import id.akademi.amanifo.course.services.models.CourseResultList;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@Builder
public class HomeItem
{
    @Builder.Default
    private List<CourseResult> courseResultList = Collections.emptyList();
}
