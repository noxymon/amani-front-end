package id.akademi.amanifo.home.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import id.akademi.amanifo.home.services.HomeService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController
{

    private final HomeService homeService;

    @GetMapping("/")
    public String index(Model model, HttpSession httpSession)
    {
        return showHome(model, httpSession);
    };

    @GetMapping("/home")
    public String showHome(Model model, HttpSession httpSession)
    {
        model.addAttribute("coursesList", homeService.build());
        model.addAttribute("loginResponse", httpSession.getAttribute("loginResponse"));
        return "homepage";
    };
}
