package id.akademi.amanifo.login.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import id.akademi.amanifo.login.controllers.models.LoginRequest;
import id.akademi.amanifo.login.controllers.models.LoginResponse;
import id.akademi.amanifo.login.services.IMemberLogin;
import id.akademi.amanifo.login.services.models.MemberLoginParameter;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController
{
    private final IMemberLogin memberLoginService;

    @GetMapping("/login")
    public String showLogin(Model model,
        @RequestParam(required = false, defaultValue = "false") String isLoginFailed,
        String failedLoginMessage, boolean redirect)
    {
        model.addAttribute("loginRequest", new LoginRequest())
            .addAttribute("isLoginFailed", Boolean.valueOf(isLoginFailed))
            .addAttribute("failedLoginMessage", failedLoginMessage);
        return redirect ? "redirect:/login" : "login";
    }

    @PostMapping("/login")
    public String doLogin(HttpSession httpSession, @ModelAttribute LoginRequest loginRequest)
    {
        try {
            MemberLoginParameter memberLoginParameter = buildMemberLoginParameter(loginRequest);

            LoginResponse loginResponse = LoginResponse.from(memberLoginService.login(memberLoginParameter));

            httpSession.setAttribute("loginResponse", loginResponse);
            return "redirect:/home";
        } catch (RestClientException e) {
            return returnLoginAfterFailed(new BindingAwareModelMap(), e);
        }
    }

    private String returnLoginAfterFailed(Model model, Throwable e)
    {
        if (e instanceof HttpClientErrorException.Unauthorized) {
            return showLogin(model, "true", "Username and Password Unknown", true);
        }
        return showLogin(model, "true", "Oops Something Happen !", true);
    }

    private MemberLoginParameter buildMemberLoginParameter(LoginRequest loginRequest)
    {
        return MemberLoginParameter.builder()
            .email(loginRequest.getEmail())
            .password(loginRequest.getPassword())
            .build();
    }
}
