package BankAccount.java908.com.java;

import BankAccount.java908.com.java.Service.ApplicationService;
import BankAccount.java908.com.java.Service.Impl.EWalletServiceImpl;


public class main {
    public static void main(String[] args) {
        ApplicationService applicationService = new EWalletServiceImpl();
        applicationService.startApp();
    }
}