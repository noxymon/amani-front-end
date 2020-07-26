package id.akademi.amanifo.registration;

import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {
    
    @GetMapping
    public String showRegisterPage(Model model, HttpSession httpSession){
        Object loginResponseFromSession = httpSession.getAttribute("loginResponse");
        if(Objects.nonNull(loginResponseFromSession)){
            return "redirect:/";
        }
        return "register";
    };
}