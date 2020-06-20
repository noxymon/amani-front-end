package id.akademi.amanifo.login.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LogoutController
{
    @GetMapping("/logout")
    public String doLogout(HttpSession httpSession)
    {
        httpSession.invalidate();
        return "redirect:/";
    }
}
