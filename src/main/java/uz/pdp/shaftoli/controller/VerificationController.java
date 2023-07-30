package uz.pdp.shaftoli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.shaftoli.entity.EmailCodeEntity;
import uz.pdp.shaftoli.entity.UserEntity;

@Controller
@RequiredArgsConstructor
public class VerificationController {
    @RequestMapping(value = "/auth/sign-up/verification", method = RequestMethod.POST)
    public String signUp(
            @ModelAttribute EmailCodeEntity emailCode,
            Model model
    ){
        UserEntity user = (UserEntity) model.getAttribute("user");
        return "index";
    }
}
