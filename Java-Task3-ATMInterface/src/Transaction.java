import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction
{
    private final String type;
    private final double amount;
    private final LocalDateTime timestamp;
    private final String details;

    public Transaction(String type, double amount, String details)
    {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString()
    {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("%s | %-12s | Rs. %10.2f | %s",
                timestamp.format(fmt), type, amount, details);
    }
}
