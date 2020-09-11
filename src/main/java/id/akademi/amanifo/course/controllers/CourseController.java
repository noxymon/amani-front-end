package id.akademi.amanifo.course.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.mobile.device.Device;
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
    public String showCourseDetail(Model model, HttpSession httpSession, Device device, @PathVariable String id)
    {
        LoginResponse loginResponse = (LoginResponse) httpSession.getAttribute("loginResponse");
        
        if(Objects.isNull(loginResponse)){
            CourseResult courseDetailWithoutLogin = fetchCourses.byId(id);
            CourseResult courseDetailWithFlagOpen = flagCourseOpenForRegistration(courseDetailWithoutLogin);
            CourseResult courseDetailWithStartFlag = flagCourseIfAlreadyStarted(courseDetailWithFlagOpen);

            model.addAttribute("courseResult", courseDetailWithStartFlag);
        }else{
            CourseResult courseDetailWithSession = fetchCourses.byIdAndMember(id, loginResponse.getId());
            CourseResult courseDetailWithFlagOpen = flagCourseOpenForRegistration(courseDetailWithSession);
            CourseResult courseDetailWithStartFlag = flagCourseIfAlreadyStarted(courseDetailWithFlagOpen);

            String courseStartUrl = courseDetailWithStartFlag.getId() + "/start";
            if(device.isMobile() || device.isTablet()){
                final String fullName = loginResponse.getFirstName() + " " + loginResponse.getLastName();
                courseStartUrl = "zoomus://zoom.us/join?confno=" + courseDetailWithStartFlag.getMeetingId() + "&pwd=inspira"+"&zc=0&uname=" + fullName;
            }

            model.addAttribute("courseStartUrl", courseStartUrl);
            model.addAttribute("courseResult", courseDetailWithStartFlag);
            model.addAttribute("loginResponse", loginResponse);
        }
        return "course-detail";
    };

    private CourseResult flagCourseOpenForRegistration(CourseResult existing){
        if(isCapacityAvailable(existing) && !isAlreadyEnd(existing)){
            CourseResult newCourseResult = new CourseResult(existing);
            newCourseResult.setOpenForRegistration(true);
            return newCourseResult;
        }
        return existing;
    }

    private boolean isAlreadyEnd(CourseResult existing)
    {
        final LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTimestamp = LocalDateTime.of(existing.getCourseStartDate(), existing.getCourseStartTime());
        LocalDateTime endTimestamp = LocalDateTime.of(existing.getCourseEndDate(), existing.getCourseEndTime());

        if(now.isAfter(startTimestamp) && now.isAfter(endTimestamp)){
            return true;
        }
        return false;
    }

    private boolean isCapacityAvailable(CourseResult existing)
    {
        return (existing.getCapacity() - existing.getRegisteredCount()) > 0;
    }

    private CourseResult flagCourseIfAlreadyStarted(CourseResult existing){
        if(isOnStart(existing)){
            CourseResult newCourseResult = new CourseResult(existing);
            newCourseResult.setAlreadyStart(true);
            return newCourseResult;
        }
        return existing;
    }

    private boolean isOnStart(CourseResult existing)
    {
        final LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTimestamp = LocalDateTime.of(existing.getCourseStartDate(), existing.getCourseStartTime());
        LocalDateTime endTimestamp = LocalDateTime.of(existing.getCourseEndDate(), existing.getCourseEndTime());

        if(now.isAfter(startTimestamp) && now.isBefore(endTimestamp)){
            return true;
        }
        return false;
    }
}
