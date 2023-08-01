package uz.pdp.shaftoli.repository.email;

import uz.pdp.shaftoli.entity.EmailCodeEntity;

public interface EmailCodeRepository {
    String UPDATE_EMAIL_CODE = "update email_code set email = :email, code = :code, limits = :limits";
    String FIND_BY_EMAIL = "select ec from email_code ec where ec.email = :email";
    void saveEmail(String email, String emailCode);

    Boolean checkEmailAndCode(String userEmail, String code);
    EmailCodeEntity findByEmail(String email);
}
