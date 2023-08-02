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
import java.util.UUID;

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
    }

    @RequestMapping(value = "/p2p")
    public String p2p(
            Model model
    ){
        return "p2p";
    }

    @RequestMapping(value = "/history")
    public String history(
            Model model
    ){
        return "history";
    }

    @RequestMapping(value = "/manage-cards")
    public String getManageCards(
            @ModelAttribute List<CardEntity> cards,
            @ModelAttribute UserEntity user,
            @RequestParam Double balance,
            Model model
    ){
        model.addAttribute("user", user);
        model.addAttribute("cards", cards);
        model.addAttribute("balance", balance);
        return "manage-cards";
    }

    @RequestMapping(value = "/manage-cards/add-card")
    public String getAddCard(
            @RequestParam UUID owner,
            Model model
    ){
        UserEntity user = userService.finById(owner);
        System.out.println("user = " + user);
        System.out.println("owner = " + owner);

        model.addAttribute("user", user);
        model.addAttribute("owner", owner);
        return "add-card";
    }

    @RequestMapping(value = "/manage-cards/add-card", method = RequestMethod.POST)
    public String addCard(
            @ModelAttribute CardEntity card,
            @RequestParam UUID owner,
            Model model
    ){
        UserEntity user = userService.finById(owner);
        System.out.println("user2" + user);
        System.out.println("findUser" + user);
        cardService.add(card);
        model.addAttribute("user", user);
        List<CardEntity> cards = cardService.myCards(user);
        model.addAttribute("balance", cardService.userCardsBalance(user));
        model.addAttribute("cards", cards);
        return "manage-cards";
    }
}
