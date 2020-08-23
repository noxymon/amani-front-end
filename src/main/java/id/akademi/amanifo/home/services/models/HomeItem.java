package id.akademi.amanifo.home.services.models;

import java.util.Collections;
import java.util.List;
import id.akademi.amanifo.course.services.models.CourseResult;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HomeItem
{
    @Builder.Default
    private List<CourseResult> courseResultList = Collections.emptyList();
}
