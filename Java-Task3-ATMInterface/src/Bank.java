import java.util.HashMap;
import java.util.Map;

public class Bank
{
    private final Map<String, Account> accounts = new HashMap<>();

    public boolean addAccount(Account account)
    {
        if(accounts.containsKey(account.getAccountId()))
        {
            return false;
        }
        accounts.put(account.getAccountId(), account);
        return true;
    }

    public Account findAccount(String accountId)
    {
        return  accounts.get(accountId);
    }
}
