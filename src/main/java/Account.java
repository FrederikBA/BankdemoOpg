import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    private List<Transaction> transactions;
    private Customer customer;

    public Account(Customer customer) {
        this.transactions = new ArrayList<>();
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getBalance() {
        int sum = 0;
        for (Transaction transaction : transactions) {
            sum += transaction.getAmount();
        }
        return sum;
    }

    public int withDrawAmount(int amount) throws InsufficientFundsException {
        if (amount <= getBalance()) {
            transactions.add(new Transaction(-amount, new Date()));
        } else {
            throw new InsufficientFundsException();
        }
        return getBalance();
    }

    public int depositAmount(int amount) throws InvalidAmountException {
        if (amount > 0) {
            transactions.add(new Transaction(amount, new Date()));
        } else {
            throw new InvalidAmountException();
        }
        return getBalance();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void showAllTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
