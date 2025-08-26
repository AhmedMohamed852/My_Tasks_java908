package BankAccount.java908.com.java.Service;

public interface AccountValidationService {

    boolean isUserNameValid(String userName);
    boolean isPasswordValid(String password);
    boolean isPhoneNumberValid(String phoneNumber);
}