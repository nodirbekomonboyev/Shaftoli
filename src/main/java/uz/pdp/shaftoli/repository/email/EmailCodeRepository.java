package uz.pdp.shaftoli.repository.email;

public interface EmailCodeRepository {
    String UPDATE_EMAIL_CODE = "update email_code set email = :email, code = :code, limit = :limit where email = :email";
    String GET_BY_EMAIL_CODE = "select ec from email_code ec where email = :email";
    String CREATE_EMAIL_CODE = "insert into email_code(email, code, limit) values(:email,:code,:limit)";
    void saveEmail(String email, String emailCode);

    Boolean checkEmailAndCode(String userEmail, String code);
}
