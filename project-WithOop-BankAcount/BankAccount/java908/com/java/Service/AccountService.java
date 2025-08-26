
package BankAccount.java908.com.java.Service;


import BankAccount.java908.com.java.Model.Account;

public interface AccountService {
    boolean createAccount(Account account);
    Account getAccount(Account account);

    boolean deposit(Account account, double amount);
    boolean withdraw(Account account, double amount);


   boolean Transfer(Account account,String userNameTransfer,double amount);
   boolean changePassword(Account account, String newPassword);
   boolean removeAccount(Account account);

}
