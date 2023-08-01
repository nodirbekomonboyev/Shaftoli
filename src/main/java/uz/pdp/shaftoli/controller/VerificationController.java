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
import uz.pdp.shaftoli.service.emailCode.EmailCodeService;

@Controller
@RequiredArgsConstructor
public class VerificationController {
    private final EmailCodeService emailCodeService;
    @RequestMapping(value = "/auth/sign-up/verification", method = RequestMethod.POST)
    public String verification(
            @RequestParam String emailCode,
            @RequestParam String userEmail,
            Model model
    ){
        model.addAttribute("userEmail", userEmail);
        Boolean verify = emailCodeService.checkEmailAndCode(userEmail, emailCode);
        System.out.println(verify.toString());
        if(verify) {
           return "manage-cards";
        }
        String massage = "Ko'dni notog'ri kiritdingiz! Tekshirib qayta kiriting!";
        model.addAttribute("massage", massage);
        return "verification";
    }

    @RequestMapping(value = "/verification")
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
