    package BankAccount.java908.com.java.Service.Impl;


    import BankAccount.java908.com.java.Model.Account;
    import BankAccount.java908.com.java.Model.EWalletSystem;
    import BankAccount.java908.com.java.Service.AccountService;
    import BankAccount.java908.com.java.Service.AccountValidationService;
    import BankAccount.java908.com.java.Service.ApplicationService;

    import java.util.Objects;
    import java.util.Scanner;

    public class EWalletServiceImpl implements ApplicationService {

        private Scanner scanner = new Scanner(System.in);

        private static final AccountService accountService = new AccountServiceImpl();
        private final AccountValidationService accountValidationService = new AccountValidationServiceImpl();
        @Override
        public void startApp() {
            System.out.println("---------- hi sir welcome to " + EWalletSystem.getName() + " ----------");

            int counter = 0;
            while (true) {
                boolean isExit = false;
                System.out.println("pls choose.");
                System.out.println("a.login     b.signup     c.exit");

                char choose = scanner.next().charAt(0);

                switch (choose) {
                    case 'a':
                        login();
                        break;
                    case 'b':
                        signup();
                        break;
                    case 'c':
                        System.out.println("have a nice day :)");
                        return;
                    default:
                        System.out.println("invalid choose :(");
                        counter++;
                }

                if (counter == 4) {
                    System.out.println("pls try after 1 min :(");
                    break;
                }

            }
        }

        private void signup() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("pls enter username.");
            String username = scanner.nextLine();
            UserNameIsValid(username);

            System.out.println("pls enter password.");
            String password = scanner.nextLine();
            passwordIsValid(password);

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("pls enter phone number.");
            String phoneNumber = scanner1.next();
            numberPhoneIsValid(phoneNumber);


            Account account = new Account(username, password, phoneNumber);

            if (accountService.createAccount(account)) {
                System.out.println("Account created success :)");
            } else {
                System.out.println("user name already exist on system :(");
            }

        }

        private void login() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("pls enter username.");
            String username = scanner.nextLine();
            System.out.println("pls enter password.");
            String password = scanner.nextLine();


            Account account = new Account(username, password);
            account = accountService.getAccount(account);

            if (Objects.nonNull(account)){
                System.out.println("login success :)");
                mainProfile(account);
            } else {
                System.out.println("invalid username or password :(");
            }
        }
    @Override
         public void mainProfile(Account account) {
            System.out.println("1.deposit  2.withdraw  3.Transfer  4.show_details  5.change password  6.remove account   7.logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); // assuming you have a Scanner named 'scanner'

            switch (choice) {
                case 1:
                    deposit(account);
                    break;

                case 2:
                    withDraw(account);
                    break;
                case 3:
                    Transfer(account);
                    break;

                case 4:
                    showAccountDetails(account);
                    break;
                case 5:
                    changepassword(account);
                    break;
                case 6:
                    removeAccount(account);
                    break;

                case 7:
                    System.out.println("Logging out...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        private void removeAccount(Account account) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Are you sure you want to delete the account..?");
            System.out.println("1-delete account    2-exit");
            int choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    boolean isValidBalance = accountService.removeAccount(account);
                    if (isValidBalance) {
                        System.out.println("Account deleted success :)");
                        startApp();
                    }else {
                        System.out.println("invalid username or password :(");
                        mainProfile(account);
                    }
                    break;
                    case 2:mainProfile(account);
                default:
                    System.out.println("Invalid choice! Please try again.");

            }

        }

        private void changepassword(Account account) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter newPassword ");
            String newPassword = scanner.nextLine();

            boolean isValidBalance = accountService.changePassword(account, newPassword);
            if (isValidBalance) {
                System.out.println("Password changed success :)");
                startApp();
            }else {
                System.out.println("invalid password :(");
                mainProfile(account);
            }
        }

        private void Transfer(Account account) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter user name of account you need To transfer");
            String usernameTransfer = scanner.nextLine();
            System.out.println("Please enter amount");
            double amount = scanner.nextDouble();

            boolean isValidBalance = accountService.Transfer(account, usernameTransfer, amount);
            if (isValidBalance) {
                System.out.println("Transfer success :)");
                mainProfile(account);
            }else {
                System.out.println("invalid username or amount :(");
                mainProfile(account);
            }
        }

        private void deposit(Account account){
            System.out.println("pls enter amount.");
            double amount = scanner.nextDouble();
          boolean res =  accountService.deposit(account, amount);
          if(res)
          {
              System.out.println("deposit success :)");
              mainProfile(account);
          }else {
              System.out.println("deposit fail :(");
              mainProfile(account);
          }

        }


        private  void withDraw(Account account){
            System.out.println("pls enter amount.");
            double amount = scanner.nextDouble();
           boolean res = accountService.withdraw(account, amount);
           if(res)
           {
               System.out.println("withdraw success :)");
               mainProfile(account);
           }

        }

      private void showAccountDetails(Account account){
            System.out.println("============> details of account :(");
            System.out.println("1-name Account is : " +account.getUserName());
            System.out.println("2-password Account is : " +account.getPassword());
            System.out.println("3-phone Number Account is : " +account.getPhoneNumber());
            System.out.println("4-balance Account is : " +account.getBalance());

            mainProfile(account);

        }

        private void UserNameIsValid(String username)
        {
            if(!accountValidationService.isUserNameValid(username)) {
                System.out.println("invalid username");
                System.out.println("must be user name of size >= 3  and first Char is UpperCase ");
                System.out.println("please try again");
                startApp();
            }
        }

        private void passwordIsValid(String password)
        {
            if(!accountValidationService.isPasswordValid(password)) {
                System.out.println("invalid password");
                System.out.println("must be password of size >= 3  and contain Char is UpperCase and contain Char is LowerCase \n => and contain any char from [@#$%&^*_+)(!]");
                System.out.println("please try again");
                startApp();
            }
        }

        private void numberPhoneIsValid(String numberPhone)
        {
            if(!accountValidationService.isPhoneNumberValid(numberPhone)) {
                System.out.println("invalid PhoneNumber");
                System.out.println("must be all Characters is Digit  And twelve(12) number ");
                System.out.println("please try again");
                startApp();
            }
        }

      // TODO  ----------------------------------------------------------------

    }