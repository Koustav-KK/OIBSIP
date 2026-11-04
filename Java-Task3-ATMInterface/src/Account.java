import java.util.ArrayList;
import java.util.List;

public class Account
{
    private final String accountId;
    private final String pin;
    private double balance;
    private final List<Transaction> history = new ArrayList<>();

    public Account(String accountId, String pin, double initialBalance)
    {
        this.accountId = accountId;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public boolean validatePin(String input)
    {
        return pin.equals(input);
    }

    public boolean deposit(double amount)
    {
        if (amount <= 0)
        {
            return false;
        }
        balance += amount;
        history.add(new Transaction("DEPOSIT", amount, ""));
        return true;
    }

    public boolean withdraw(double amount)
    {
        if (amount <= 0 || amount > balance ) {
            return false;
        }
        balance -= amount;
        history.add(new Transaction("WITHDRAW", amount, ""));
        return true;
    }

    public boolean transferTo(Account target, double amount)
    {
        if( amount <= 0 || amount > balance )
        {
            return false;
        }

        if( target == null || target == this)
        {
            return false;
        }

        this.balance -= amount;
        target.balance += amount;

        this.history.add(new Transaction("TRANSFER OUT", amount, "To " + target.accountId));
        target.history.add(new Transaction("TRANSFER IN", amount, "From " + this.accountId));
        return true;
    }

    public List<Transaction> getHistory()
    {
        return List.copyOf(history);
    }
}
