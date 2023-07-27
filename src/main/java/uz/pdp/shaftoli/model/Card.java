package uz.pdp.shaftoli.model;

import java.util.UUID;

public class Card extends BaseModel{
    private UUID ownerId;
    private String cardNumber;
    private Double balance;
    private CardType type;
    private Boolean status;
}
