package uz.pdp.shaftoli.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Card extends BaseModel{
    private UUID ownerId;
    private String cardNumber;
    private Double balance;
    private CardType type;
    private Boolean status;
}
