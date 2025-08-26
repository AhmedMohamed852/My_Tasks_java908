
package BankAccount.java908.com.java.Service.Impl;


import BankAccount.java908.com.java.Service.AccountValidationService;

public class AccountValidationServiceImpl implements AccountValidationService {

    @Override
    public boolean isUserNameValid(String userName) {
        return Character.isUpperCase(userName.charAt(0)) && userName.length() >= 3;
    }

    @Override
    public boolean isPasswordValid(String password) {
       boolean bol1 = password.chars().anyMatch(Character::isUpperCase);
       boolean bol2 = password.chars().anyMatch(Character::isLowerCase);
       boolean bol3 = password.chars().anyMatch(Character::isDigit);
       boolean bol4 = password.chars().anyMatch(n -> n == '*' || n == '@' || n == '#' || n == '%' || n == '&' || n == '^' || n == '-' || n == '+' || n == '_' || n == '[' || n == ']' || n == '(' || n == ')' || n == '!' );
       boolean bol5 = password.length() >= 10;

     return   bol1 && bol2 && bol3 && bol4 && bol5 ;

    }

    @Override
    public boolean isPhoneNumberValid(String phoneNumber) {
        boolean bol1 = phoneNumber.chars().allMatch(Character::isDigit);
        boolean bol2 = phoneNumber.startsWith("20");
        boolean bol3 = phoneNumber.length() == 12;

        return bol1 && bol2 && bol3 ;
    }
}
