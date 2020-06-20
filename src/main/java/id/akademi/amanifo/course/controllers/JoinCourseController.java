package id.akademi.amanifo.course.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import id.akademi.amanifo.course.controllers.models.JoinCourseRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class JoinCourseController {
    
    @PostMapping("/{id}/join")
    public ResponseEntity doJoinCourse(@PathVariable("id") String id, @RequestBody JoinCourseRequest JoinCourseRequest )
    {
        return new ResponseEntity<>(HttpStatus.OK);
    };
      
}