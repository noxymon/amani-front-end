package id.akademi.amanifo.course.controllers;

import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import id.akademi.amanifo.course.controllers.models.JoinCourseRequest;
import id.akademi.amanifo.course.services.GenerateMeetingConfig;
import id.akademi.amanifo.course.services.IFetchCourses;
import id.akademi.amanifo.course.services.models.CourseResult;
import id.akademi.amanifo.course.services.models.MeetingConfig;
import id.akademi.amanifo.login.controllers.models.LoginResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class StartCourseController
{
    private final IFetchCourses         fetchCourse;
    private final GenerateMeetingConfig generateMeetingConfig;

    @GetMapping("/{id}/start")
    public String doJoinCourse(Model model, HttpSession httpSession, @PathVariable("id") String id)
    {
        Object sessionAttribute = httpSession.getAttribute("loginResponse");
        if(Objects.nonNull(sessionAttribute)){
            LoginResponse loginResponseFromSession = (LoginResponse) sessionAttribute;
            CourseResult singleCourseById = fetchCourse.byId(id);
            MeetingConfig generatedMeetingConfig = generateMeetingConfig.generate(
                singleCourseById.getMeetingId(),
                loginResponseFromSession.getFirstName() + loginResponseFromSession.getLastName(),
                loginResponseFromSession.getEmail()
            );
            model.addAttribute("loginResponse", loginResponseFromSession);
            model.addAttribute("meetingConfig", generatedMeetingConfig);
            return "course-start";
        }
        return "redirect:/login";
    };
}
