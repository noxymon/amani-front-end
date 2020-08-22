package id.akademi.amanifo.course.controllers;

import id.akademi.amanifo.course.controllers.models.JoinCourseRequest;
import id.akademi.amanifo.course.controllers.models.JoinCourseResponse;
import id.akademi.amanifo.course.services.models.JoinCourseParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import id.akademi.amanifo.course.services.IJoinCourse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class JoinCourseController
{
    private final IJoinCourse joinCourseService;

    @PostMapping("/{courseId}/join")
    public ResponseEntity<JoinCourseResponse> doJoinCourse(@PathVariable String courseId, @RequestBody JoinCourseRequest joinCourseRequest)
    {
        final JoinCourseParam joinCourseParam = buildJoinCourseParam(courseId, joinCourseRequest);
        joinCourseService.doJoin(joinCourseParam);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private JoinCourseParam buildJoinCourseParam(String courseId, JoinCourseRequest joinCourseRequest)
    {
        return JoinCourseParam
          .builder()
          .courseId(courseId)
          .memberId(joinCourseRequest.getMemberId())
          .build();
    }
}
