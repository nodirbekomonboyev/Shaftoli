package uz.pdp.shaftoli.repository.email;

public interface EmailCodeRepository {
    void save(String email, String emailCode);
}
