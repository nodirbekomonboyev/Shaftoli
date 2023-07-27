package uz.pdp.shaftoli.repository.card;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.pdp.shaftoli.model.Card;
import uz.pdp.shaftoli.model.CardMapper;

import java.util.ArrayList;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CardRepositoryImpl implements CardRepository{

        private final JdbcTemplate jdbcTemplate;

        @Override
        public Card save(Card card) {
            jdbcTemplate.update(
                    INSERT_CARD,
                    card.getId(),
                    card.getOwnerId(),
                    card.getCardNumber(),
                    card.getPassword(),
                    card.getBalance(),
                    card.getType(),
                    card.getStatus());
            return card;
        }

        @Override
        public Card getById(UUID id) {
            return jdbcTemplate.queryForObject(GET_CARD_BY_ID, new CardMapper(), id);
        }

      //  public Card findByCardname(String username) {
      //      Card user = jdbcTemplate.queryForObject(GET_USER_BY_USERNAME, new CardMapper(), username);
      //      return user;
//
      //  }

        @Override
        public ArrayList<Card> getAll() {
            return (ArrayList<Card>) jdbcTemplate.query(GET_ALL, new CardMapper());
        }
}
