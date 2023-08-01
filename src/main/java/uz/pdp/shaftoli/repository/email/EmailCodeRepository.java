package uz.pdp.shaftoli.repository.email;

public interface EmailCodeRepository {
    String UPDATE_EMAIL_CODE = "update email_code set email = :email, code = :code, limits = :limits";

    String GET_BY_EMAIL_CODE = "select ec from email_code ec where email = :email";
    void saveEmail(String email, String emailCode);

    Boolean checkEmailAndCode(String userEmail, String code);
}
