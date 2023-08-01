package uz.pdp.shaftoli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.shaftoli.entity.UserEntity;

@Controller
@RequiredArgsConstructor
public class MainController {
    @RequestMapping(value = "/payment")
    public String payment(
            Model model
    ){
        return "payment";
    }@RequestMapping(value = "/p2p")
    public String p2p(
            Model model
    ){
        return "p2p";
    }@RequestMapping(value = "/history")
    public String history(
            Model model
    ){
        return "history";
    }@RequestMapping(value = "/manage-cards")
    public String manageCards(
            Model model
    ){
        return "manage-cards";
    }
}
