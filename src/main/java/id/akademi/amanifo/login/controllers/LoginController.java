package id.akademi.amanifo.login.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
      String failedLoginMessage,
      boolean redirect,
      @RequestParam(required = false) String prevUrl)
    {
        final Boolean booleanLoginFailed = Boolean.valueOf(isLoginFailed);
        final String loginUrlWithQueryParam = StringUtils.isEmpty(prevUrl) ? "/login" : "/login?prevUrl="+prevUrl;

        model.addAttribute("loginRequest", new LoginRequest())
             .addAttribute("isLoginFailed", booleanLoginFailed)
             .addAttribute("failedLoginMessage", failedLoginMessage)
             .addAttribute("loginUrlWithQueryParam", loginUrlWithQueryParam);
        return redirect ? "redirect:/login?isLoginFailed="+ booleanLoginFailed +"&failedLoginMessage="+failedLoginMessage : "login";
    }

    @PostMapping("/login")
    public String doLogin(HttpSession httpSession, @ModelAttribute LoginRequest loginRequest, @RequestParam(required = false) String prevUrl)
    {
        try {
            MemberLoginParameter memberLoginParameter = buildMemberLoginParameter(loginRequest);

            LoginResponse loginResponse = LoginResponse.from(memberLoginService.login(memberLoginParameter));

            httpSession.setAttribute("loginResponse", loginResponse);

            return "redirect:"+ getRedirectUrl(prevUrl);
        } catch (RestClientException e) {
            return returnLoginAfterFailed(new BindingAwareModelMap(), e);
        }
    }

    private String getRedirectUrl(String prevUrl)
    {
        return StringUtils.isEmpty(prevUrl) ? "/home" : prevUrl;
    }

    private String returnLoginAfterFailed(Model model, Throwable e)
    {
        return showLogin(model, "true", "Periksa kembali username dan password kamu ya :)", true, null);
    }

    private MemberLoginParameter buildMemberLoginParameter(LoginRequest loginRequest)
    {
        return MemberLoginParameter.builder()
            .email(loginRequest.getEmail())
            .password(loginRequest.getPassword())
            .build();
    }
}
