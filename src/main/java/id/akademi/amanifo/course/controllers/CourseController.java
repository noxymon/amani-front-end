package id.akademi.amanifo.course.controllers;

import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import id.akademi.amanifo.course.services.IFetchCourses;
import id.akademi.amanifo.course.services.models.CourseResult;
import id.akademi.amanifo.login.controllers.models.LoginResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final IFetchCourses fetchCourses;

    @GetMapping("/{id}")
    public String showCourseDetail(Model model, HttpSession httpSession, @PathVariable String id)
    {
        LoginResponse loginResponse = (LoginResponse) httpSession.getAttribute("loginResponse");
        
        if(Objects.isNull(loginResponse)){
            CourseResult courseDetailWithoutLogin = fetchCourses.byId(id);
            CourseResult courseDetailWithFlagOpen = flagCourseOpenForRegistration(courseDetailWithoutLogin);

            model.addAttribute("courseResult", courseDetailWithFlagOpen);
        }else{
            CourseResult courseDetailWithSession = fetchCourses.byIdAndMember(id, loginResponse.getId());
            CourseResult courseDetailWithFlagOpen = flagCourseOpenForRegistration(courseDetailWithSession);
            
            model.addAttribute("courseResult", courseDetailWithFlagOpen);
            model.addAttribute("loginResponse", loginResponse);
        }
        return "course-detail";
    };

    private CourseResult flagCourseOpenForRegistration(CourseResult existing){
        if(existing.getDaysBeforeStartDate() > 0 && !existing.isAlreadyJoined()){
            CourseResult newCourseResult = new CourseResult(existing);
            newCourseResult.setOpenForRegistration(true);
            return newCourseResult;
        }
        return existing;
    };
}