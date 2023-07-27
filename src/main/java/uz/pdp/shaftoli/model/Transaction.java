package uz.pdp.shaftoli.model;

import java.util.UUID;

public class Transaction extends BaseModel{
    private UUID senderId;
    private UUID receiverId;
    private Double amount;
    private Double percentage;
}
