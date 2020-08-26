package id.akademi.amanifo.admin.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AddCourseController
{
    @GetMapping("/admin/course/add")
    public String showDashboardCourse(Model model)
    {
        model.addAttribute("content", "admin/add-course");
        return "admin/dashboard";
    }
}
