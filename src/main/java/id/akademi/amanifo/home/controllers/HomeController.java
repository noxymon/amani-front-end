package id.akademi.amanifo.home.controllers;

import id.akademi.amanifo.course.services.IFetchCourses;
import id.akademi.amanifo.home.services.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/")
    public String index(Model model, HttpSession httpSession){
        return showHome(model, httpSession);
    };

    @GetMapping("/home")
    public String showHome(Model model, HttpSession httpSession){
        model.addAttribute("coursesList", homeService.build());
        model.addAttribute("loginResponse", httpSession.getAttribute("loginResponse"));
        return "homepage";
    };
}