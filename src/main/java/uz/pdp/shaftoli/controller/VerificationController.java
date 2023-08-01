package uz.pdp.shaftoli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.shaftoli.entity.EmailCodeEntity;
import uz.pdp.shaftoli.entity.UserEntity;

@Controller
@RequiredArgsConstructor
public class VerificationController {
    @RequestMapping(value = "/auth/sign-up/verification", method = RequestMethod.POST)
    public String signUp(
            @RequestParam String emailCode,
            @RequestParam String code,
            @RequestParam String userEmail,
            Model model
    ){
        System.out.println("emailcode = " + emailCode);
        System.out.println("code = " + code);
        if(emailCode.equals(code)) {
           return "index";
        }
        String massage = "Ko'dni notog'ri kiritdingiz! Tekshirib qayta kiriting!";
        model.addAttribute("massage", massage);
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("code", code);
        return "verification";
    }

    @RequestMapping(value = "/auth/sign-up/verification")
    public String signUp(
            Model model
    ){
        UserEntity user = (UserEntity) model.getAttribute("user");
        String code = (String) model.getAttribute("code");
        String message = (String) model.getAttribute("message");
        model.addAttribute("massage", message);
        model.addAttribute("user", user);
        model.addAttribute("code", code);
        return "verification";
    }


}
