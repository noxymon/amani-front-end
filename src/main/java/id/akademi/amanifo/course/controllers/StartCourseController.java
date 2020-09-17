package id.akademi.amanifo.course.controllers;

import java.util.Objects;
import javax.servlet.http.HttpSession;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import id.akademi.amanifo.course.services.GenerateMeetingConfig;
import id.akademi.amanifo.course.services.IFetchCourses;
import id.akademi.amanifo.course.services.models.CourseResult;
import id.akademi.amanifo.course.services.models.MeetingConfig;
import id.akademi.amanifo.login.controllers.models.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class StartCourseController
{
    private final IFetchCourses         fetchCourse;
    private final GenerateMeetingConfig generateMeetingConfig;

    @GetMapping("/{id}/start")
    public String doJoinCourse(Model model, HttpSession httpSession, Device device, @PathVariable("id") String id,
      @RequestParam(required = false) boolean useFallback)
    {
        LoginResponse loginResponse = (LoginResponse) httpSession.getAttribute("loginResponse");
        if(Objects.nonNull(loginResponse)){
            CourseResult singleCourseById = fetchCourse.byId(id);
            final String courseStartUrlFromDevice = getCourseStartUrlFromDevice(device, loginResponse, singleCourseById);

            if(useFallback){
                return doJoinCourseWithFallback(model, httpSession, id);
            }

            model.addAttribute("courseResult", singleCourseById);
            model.addAttribute("courseStartUrl", courseStartUrlFromDevice);
            return "course-start";
        }
        return "redirect:/login";
    }

    public String doJoinCourseWithFallback(Model model, HttpSession httpSession, String id)
    {
        LoginResponse loginResponseFromSession = (LoginResponse) httpSession.getAttribute("loginResponse");
        CourseResult singleCourseById = fetchCourse.byId(id);
        MeetingConfig generatedMeetingConfig = generateMeetingConfig.generate(
          singleCourseById.getMeetingId(),
          loginResponseFromSession.getFirstName() + loginResponseFromSession.getLastName(),
          loginResponseFromSession.getEmail()
        );

        String fallbackUrl = singleCourseById.getId() + "/start?useFallback=true";

        model.addAttribute("courseResult", singleCourseById);
        model.addAttribute("fallbackUrl", fallbackUrl);
        model.addAttribute("loginResponse", loginResponseFromSession);
        model.addAttribute("meetingConfig", generatedMeetingConfig);

        return "fallback-course";
    }

    private String getCourseStartUrlFromDevice(Device device, LoginResponse loginResponse, CourseResult courseDetailWithStartFlag)
    {
        final String fullName = loginResponse.getFirstName() + " " + loginResponse.getLastName();
        String courseStartUrl = "zoommtg://zoom.us/join?confno=" + courseDetailWithStartFlag.getMeetingId() + "&pwd=" + courseDetailWithStartFlag.getPasscode() +
                                "&zc=0&uname=" + fullName;
        if (device.isMobile() || device.isTablet()) {
            if (device.getDevicePlatform().equals(DevicePlatform.ANDROID) || device.getDevicePlatform().equals(DevicePlatform.IOS)) {
                courseStartUrl = "zoomus://zoom.us/join?confno=" + courseDetailWithStartFlag.getMeetingId() + "&pwd=" + courseDetailWithStartFlag.getPasscode() +
                                 "&zc=0&uname=" + fullName;
            }
        }
        return courseStartUrl;
    }
}
