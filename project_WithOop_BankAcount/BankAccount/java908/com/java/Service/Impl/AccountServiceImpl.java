package BankAccount.java908.com.java.Service.Impl;



import BankAccount.java908.com.java.Model.Account;
import BankAccount.java908.com.java.Model.EWalletSystem;
import BankAccount.java908.com.java.Service.AccountService;
import BankAccount.java908.com.java.Service.AccountValidationService;

import java.util.List;
import java.util.stream.IntStream;

//       TODO remove any duplicated code

public class AccountServiceImpl implements AccountService {

    private static final EWalletSystem eWalletSystem = new EWalletSystem();
    private final AccountValidationService accountValidationService = new AccountValidationServiceImpl();

    List<Account> accounts = eWalletSystem.getAccounts();
    @Override
    public boolean createAccount(Account account) {    // TODO no duplicated code
        String type = "createAccount";
       return creatOrLoginOrDeleteAccount(account ,type);
    }

    @Override
    public Account getAccount(Account account) {  // TODO no duplicated code
        String type = "getAccount";
        if(creatOrLoginOrDeleteAccount(account  ,type))
        { return account; }
        return null;
    }

    @Override
    public boolean deposit(Account account, double amount) {   // TODO no duplicated code
        String type = "deposit";
        return  updateBalanceAndPassword(account ,amount , type);
    }

    @Override
    public boolean withdraw(Account account, double amount) {    // TODO no duplicated code
        String type = "withdraw";
        return  updateBalanceAndPassword(account ,amount , type);

    }


    @Override
    public boolean Transfer(Account account, String userNameTransfer, double amount) {  // TODO no duplicated code
       return updateBalanceAndPassword(account ,amount , userNameTransfer);
        }

    @Override
    public boolean changePassword(Account account, String newPassword) {   // TODO no duplicated code
        if(accountValidationService.isPasswordValid(newPassword))
        { return updateBalanceAndPassword(account ,0.0 ,newPassword);}
        return false;
    }

    @Override
    public boolean removeAccount(Account account) {
        String type = "removeAccount";
        return creatOrLoginOrDeleteAccount(account,"removeAccount");
    }



    private boolean updateBalanceAndPassword(Account account ,double amount, String type){
        int  my_account_index = IntStream.range(0,accounts.size()).filter(i -> accounts.get(i).getUserName().equals(account.getUserName())).findFirst().orElse(-1);
      int  account_Transfer_index = IntStream.range(0,accounts.size()).filter(i -> accounts.get(i).getUserName().equals(type)).findFirst().orElse(-1);

        switch (type){
            case "deposit":
                accounts.get(my_account_index).setBalance(accounts.get(my_account_index).getBalance() + amount);
                return true;
                case "withdraw":
                accounts.get(my_account_index).setBalance(accounts.get(my_account_index).getBalance() - amount);
                return true;
                case "getAccount":
                    for (Account acc : accounts) {
                        if (acc.getUserName().equals(account.getUserName()) && acc.getPassword().equals(account.getPassword())) {
                            return true;
                        }
                    }
        }
        if(amount == 0.0 && my_account_index != -1){
            accounts.get(my_account_index).setPassword(type);
            return true;
        }

        if(account_Transfer_index != -1 && my_account_index != -1 || account_Transfer_index != my_account_index) {
            if(accounts.get(my_account_index).getBalance() < amount) {return false;}
            accounts.get(my_account_index).setBalance(accounts.get(my_account_index).getBalance() - amount);
            accounts.get(account_Transfer_index).setBalance(accounts.get(account_Transfer_index).getBalance() + amount);
            return true;
        }
        return false;
    }

    private boolean  creatOrLoginOrDeleteAccount(Account account , String type)
        {
            int my_account_index = IntStream.range(0,accounts.size()).filter(i -> accounts.get(i).getUserName().equals(account.getUserName())&&accounts.get(i).getPassword().equals(account.getPassword())).findFirst().orElse(-1);

            switch (type){
                case "createAccount":
                    for (Account acc : accounts) {
                        if (acc.getUserName().equals(account.getUserName())) {
                            return false;
                        }
                    }
                    accounts.add(account);
                    return true;
                    case "getAccount":
                        for (Account acc : accounts) {
                            if (acc.getUserName().equals(account.getUserName()) && acc.getPassword().equals(account.getPassword())) {
                                return true;
                            }
                        }
                case "removeAccount":
                    if(my_account_index != -1){
                        accounts.remove(my_account_index);
                        return true;
                    }
                default:
                    return false;
            }
        }




}
