package uz.pdp.shaftoli.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class
User extends BaseModel{
    private String name;
    private UserRole role;
    private String email;
    private String password;
    private Boolean validated;
}
