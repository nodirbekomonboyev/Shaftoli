package uz.pdp.shaftoli.service.card;


import org.springframework.stereotype.Service;
import uz.pdp.shaftoli.entity.CardEntity;
import uz.pdp.shaftoli.entity.CardType;
import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.repository.card.CardRepository;
import uz.pdp.shaftoli.repository.user.UserRepository;
import uz.pdp.shaftoli.service.BaseService;

import java.util.ArrayList;

@Service
public class CardServiceImpl implements BaseService<CardEntity> {
    @Override
    public CardEntity add(CardEntity card) {
        return null;
    }

    @Override
    public ArrayList<CardEntity> getAll() {
        return null;
    }

    @Override
    public CardEntity getById() {
        return null;
    }
}
