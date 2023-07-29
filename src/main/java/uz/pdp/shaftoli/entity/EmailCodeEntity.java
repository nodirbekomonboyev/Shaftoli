package uz.pdp.shaftoli.entity;


import jakarta.persistence.Entity;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "email_code")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmailCodeEntity extends BaseModel {
    private String email;
    private String code;
    @Timestamp
    private LocalDateTime limit;
}
