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
public class Transaction extends BaseModel{
    private UUID senderId;
    private UUID receiverId;
    private Double amount;
    private Double percentage;
}
