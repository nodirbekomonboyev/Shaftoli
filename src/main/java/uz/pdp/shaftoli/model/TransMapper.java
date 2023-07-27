package uz.pdp.shaftoli.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class TransMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Transaction card = Transaction.builder()
                .senderId(UUID.fromString(rs.getString("sender_id")))
                .receiverId(UUID.fromString(rs.getString("reciever_id")))
                .amount(rs.getDouble("amount"))
                .percentage(rs.getDouble("percentage"))
                .build();
        card.setId(UUID.fromString(rs.getString("id")));
        card.setCreatedDate(rs.getTimestamp("created_date"));
        card.setUpdatedDate(rs.getTimestamp("updated_date"));
        return card;
    }
}
