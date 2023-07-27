package uz.pdp.shaftoli.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class CardMapper implements RowMapper<Card> {

    @Override
    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
        Card card = Card.builder()
                .ownerId(UUID.fromString(rs.getString("owner_id")))
                .cardNumber(String.valueOf(rs.getInt("card_number")))
                .password(rs.getString("password"))
                .balance(Double.valueOf(rs.getString("balance")))
                .type(CardType.valueOf(rs.getString("type")))
                .status(Boolean.valueOf(rs.getString("status")))
                .build();
        card.setId(UUID.fromString(rs.getString("id")));
        card.setCreatedDate(rs.getTimestamp("created_date"));
        card.setUpdatedDate(rs.getTimestamp("updated_date"));
        return card;
    }
}
