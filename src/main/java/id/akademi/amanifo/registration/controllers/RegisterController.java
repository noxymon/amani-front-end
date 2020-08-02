package id.akademi.amanifo.registration.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.akademi.amanifo.registration.controllers.models.RegisterRequest;
import id.akademi.amanifo.registration.services.IMemberRegister;
import id.akademi.amanifo.registration.services.models.MemberRegisterParam;
import id.akademi.amanifo.registration.services.models.MemberRegisterResult;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController
{
    private final IMemberRegister memberRegisterService;

    @GetMapping
    public String showRegisterPage(Model model, HttpSession httpSession)
    {
        Object loginResponseFromSession = httpSession.getAttribute("loginResponse");
        if (Objects.nonNull(loginResponseFromSession)) {
            return "redirect:/";
        }
        return "register";
    };

    @PostMapping
    public String doRegister(HttpSession httpSession, @ModelAttribute RegisterRequest registerRequest)
    {
        MemberRegisterParam memberRegisterParam = composeMemberRegisterParam(registerRequest);
        MemberRegisterResult registerResult = memberRegisterService.register(memberRegisterParam);
        return "redirect:/register/welcome";
    }

    private MemberRegisterParam composeMemberRegisterParam(RegisterRequest registerRequest)
    {
        LocalDate dateOfBirthTemporal = LocalDate.parse(registerRequest.getDateOfBirth(), DateTimeFormatter.ofPattern("MMMM, dd yyyy"));
        return MemberRegisterParam.builder()
                                  .email(registerRequest.getEmail())
                                  .dateOfBirth(dateOfBirthTemporal)
                                  .firstName(registerRequest.getFirstName())
                                  .lastName(registerRequest.getLastName())
                                  .password(registerRequest.getPassword())
                                  .build();
    };

    @GetMapping("/welcome")
    public String showPostRegister()
    {
        return "register-post";
    };
}
