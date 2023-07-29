package uz.pdp.shaftoli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.shaftoli.model.User;
import uz.pdp.shaftoli.service.user.UserService;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @RequestMapping(value = "/auth/sign-up")
    public String signUpPage() {

        return "sign-up";
    }

    @RequestMapping(value = "/auth/sign-up", method = RequestMethod.POST)
    public String signUp(@ModelAttribute User user) {

        userService.add(user);
        return "verification";
    }

    @RequestMapping("/auth/sign-in")
    public String signInPage()
    {
        return "sign-in";
    }

    @RequestMapping(value = "/auth/sign-in", method = RequestMethod.POST)
    public String signInPage(@RequestParam String username, @RequestParam String password)
    {
        return "index";
    }

}
