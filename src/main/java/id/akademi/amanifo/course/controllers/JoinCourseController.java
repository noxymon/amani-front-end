package id.akademi.amanifo.course.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import id.akademi.amanifo.course.controllers.models.JoinCourseRequest;
import id.akademi.amanifo.course.services.GenerateMeetingConfig;
import id.akademi.amanifo.course.services.models.MeetingConfig;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class JoinCourseController {

    private final GenerateMeetingConfig generateMeetingConfig;
    
    @PostMapping("/{id}/join")
    public ResponseEntity doJoinCourse(@PathVariable("id") String id, @RequestBody JoinCourseRequest JoinCourseRequest )
    {
        return new ResponseEntity<>(HttpStatus.OK);
    };

    @GetMapping("/{id}/start")
    public String startCourse(Model model, @PathVariable("id") String id){
        MeetingConfig generatedMeetingConfig = generateMeetingConfig.generate(id);
        model.addAttribute("meetingConfig", generatedMeetingConfig);
        return "course-start";
    };
}