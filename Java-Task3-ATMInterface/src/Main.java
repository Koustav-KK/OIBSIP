public class Main
{
    public static void main(String[] args)
    {
        Bank bank = new Bank();

        bank.addAccount(new Account("ACC1001", "1234", 10000));
        bank.addAccount(new Account("ACC1002", "5678", 5000));
        bank.addAccount(new Account("ACC1003", "0000", 2500));

        ATM atm = new ATM(bank);
        atm.start();
    }
}
