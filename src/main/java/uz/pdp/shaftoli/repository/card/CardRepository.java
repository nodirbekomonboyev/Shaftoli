package uz.pdp.shaftoli.repository.card;

import uz.pdp.shaftoli.entity.Card;
import uz.pdp.shaftoli.repository.BaseRepository;

import java.util.UUID;

public interface CardRepository extends BaseRepository<Card> {
//new fileasdfasd
     String INSERT_CARD = "insert into users(id, owner_id, curd_number, password, balance, type, status) " +
        "values(?, ?, ?, ?, ?, ?, ?);";
    String GET_CARD_BY_ID = "select * from card c where c.id = ?;";
    //String GET_CARD_BY_USERNAME = "select * from card where username = ?;";
    String GET_ALL = "select * from card;";

    Card getById(UUID id);
}
