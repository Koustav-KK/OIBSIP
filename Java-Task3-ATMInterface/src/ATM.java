import java.util.List;
import java.util.Scanner;

public class ATM
{
    private static final int MAX_ATTEMPTS = 3;

    private final Bank bank;
    private final Scanner scanner;
    private Account currentAccount;

    public ATM(Bank bank)
    {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    private boolean login()
    {
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++)
        {
            System.out.print("Enter User ID: ");
            String id = scanner.next();
            System.out.print("Enter PIN: ");
            String pin = scanner.next();

            Account acc = bank.findAccount(id);
            if (acc != null && acc.validatePin(pin))
            {
                currentAccount = acc;
                System.out.println("Login Successful. Welcome, " + id + "!");
                return true;
            }

            int left = MAX_ATTEMPTS - attempt;
            if (left > 0)
            {
                System.out.println("Invalid credentials. Attempts left: " + left);
            }
        }
        System.out.println("Too many incorrect attempts. Access denied.");
        return false;
    }

    private double readAmount()
    {
        System.out.print("Enter amount: ");
        while (!scanner.hasNextDouble())
        {
            System.out.print("Not a number. Enter amount: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private void printBalance()
    {
        System.out.println("Current balance: Rs. " + String.format("%.2f", currentAccount.getBalance()));
    }

    private void showHistory()
    {
        List<Transaction> history = currentAccount.getHistory();
        if(history.isEmpty())
        {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("\n----- Transaction History -----");
        for (Transaction t : history)
        {
            System.out.println(t);
        }
    }

    private void withdraw()
    {
        double amount = readAmount();
        if (amount <= 0)
        {
            System.out.println("Invalid amount. Must be greater than 0.");
        }
        else if(currentAccount.withdraw(amount))
        {
            System.out.println("Withdrew Rs. " + String.format("%.2f", amount) + " successfully.");
            printBalance();
        }
        else
        {
            System.out.println("Insufficient Funds.");
        }
    }

    private void deposit()
    {
        double amount = readAmount();
        if (currentAccount.deposit(amount))
        {
            System.out.println("Deposited Rs. " + String.format("%.2f", amount) + " successfully.");
            printBalance();
        }
        else
        {
            System.out.println("Invalid amount. Must be greater than 0.");
        }
    }

    private void transfer()
    {
        System.out.print("Enter recipient Account ID: ");
        String targetId = scanner.next();
        Account target = bank.findAccount(targetId);

        if(target == null)
        {
            System.out.println("Recipient account not found.");
            return;
        }
        if(target == currentAccount)
        {
            System.out.println("Cannot transfer to your own account.");
            return;
        }

        double amount = readAmount();
        if (amount <= 0)
        {
            System.out.println("Invalid amount. Must be greater than 0.");
        }
        else if (currentAccount.transferTo(target, amount))
        {
            System.out.println("Transferred Rs. " + String.format("%.2f", amount) + " to " + targetId + ".");
            printBalance();
        }
        else
        {
            System.out.println("Insufficient Funds.");
        }
    }

    public void start()
    {
        System.out.println("===== Welcome to the ATM =====");
        if(!login())
        {
            return;
        }
        printBalance();

        while (true)
        {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt())
            {
                System.out.println("Invalid input. Enter a number 1-5.");
                scanner.next();
                continue;
            }

            switch (scanner.nextInt())
            {
                case 1 -> showHistory();
                case 2 -> withdraw();
                case 3 -> deposit();
                case 4 -> transfer();
                case 5 ->  {
                    System.out.println("Thank you for banking with us. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Choose 1-5.");
            }
        }
    }

}

