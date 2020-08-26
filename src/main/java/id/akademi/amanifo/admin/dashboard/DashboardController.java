package id.akademi.amanifo.admin.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController
{
    @GetMapping("/admin/dashboard")
    public String showDashboard(Model model)
    {
        model.addAttribute("content", "admin/console");
        return "admin/dashboard";
    }
}
