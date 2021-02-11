import java.util.List;

public class Main {

    public static void main(String[] args) {
        Customer c1 = new Customer("Jon");
        Account account = new Account(c1);
        int newBalance;

        try {
            newBalance = account.depositAmount(125);
            newBalance = account.depositAmount(325);
            newBalance = account.depositAmount(500);
            newBalance = account.depositAmount(100);
        } catch (InvalidAmountException e) {
            e.printErrorMessage();
        }
        try {
            newBalance = account.withDrawAmount(50);
        } catch (InsufficientFundsException e) {
            e.printErrorMessage();
        }
        System.out.println("Total balance: " + account.getBalance());
        account.showAllTransactions();
    }
}
