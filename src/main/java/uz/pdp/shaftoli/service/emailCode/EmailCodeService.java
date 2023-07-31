package uz.pdp.shaftoli.service.emailCode;

public interface EmailCodeService {

    String sendAndReturnCodeToEmail(String receiverEmail);
}
