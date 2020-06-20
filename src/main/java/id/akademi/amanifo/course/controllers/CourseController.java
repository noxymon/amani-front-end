package id.akademi.amanifo.course.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import id.akademi.amanifo.course.services.IFetchCourses;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final IFetchCourses fetchCourses;

    @GetMapping("/{id}")
    public String showCourseDetail(Model model, HttpSession httpSession, @PathVariable String id)
    {
        model.addAttribute("loginResponse", httpSession.getAttribute("loginResponse"));
        model.addAttribute("courseResult", fetchCourses.byId(id));
        return "course-detail";
    };
}