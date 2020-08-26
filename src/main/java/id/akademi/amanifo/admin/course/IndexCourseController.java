package id.akademi.amanifo.admin.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class IndexCourseController
{
    @GetMapping("/admin/course")
    public String showDashboardCourse(Model model)
    {
        model.addAttribute("content", "admin/course-list");
        return "admin/dashboard";
    }
}
