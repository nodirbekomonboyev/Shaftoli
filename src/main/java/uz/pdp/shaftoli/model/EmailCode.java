package uz.pdp.shaftoli.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmailCode extends BaseModel {
    private String email;
    private String code;
    private Timestamp limit;
}
