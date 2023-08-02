package uz.pdp.shaftoli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.shaftoli.entity.CardEntity;
import uz.pdp.shaftoli.entity.CardType;
import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.service.card.CardService;
import uz.pdp.shaftoli.service.user.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final CardService cardService;
    private final UserService userService;
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
    }


    @RequestMapping(value = "/manage-cards/add-card", method = RequestMethod.POST)
    public String

    addCard(
            @ModelAttribute CardEntity card,
            @ModelAttribute UserEntity user,
            Model model
    ){

        cardService.add(card);
        System.out.println("user = " + user);

        List<CardEntity> cards = cardService.myCards(user);
        model.addAttribute("user", user);
        model.addAttribute("balance", cardService.userCardsBalance(user));
        model.addAttribute("cards", cards);
        return "manage-cards";
    }
}
