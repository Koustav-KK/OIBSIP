\# Java Task 3 – ATM Interface



A console-based ATM simulation built in Java with object-oriented design. Users log in with a User ID and PIN, then view their transaction history, withdraw, deposit, or transfer money to another account.



\## Features

\- \*\*Secure login\*\*: User ID + PIN; access is denied after 3 incorrect attempts

\- \*\*Main menu\*\*

&#x20; 1. Transaction History – all transactions in the session, with timestamps

&#x20; 2. Withdraw – checks the balance, then updates it and logs the transaction

&#x20; 3. Deposit – updates the balance and logs the transaction

&#x20; 4. Transfer – moves money to another account and logs it on both accounts

&#x20; 5. Quit

\- "Insufficient Funds" check before any withdrawal or transfer

\- Validation for negative/zero amounts, unknown recipients, self-transfers and non-numeric input



\## Project Structure

| Class | Responsibility |

|-------|----------------|

| `Main` | Creates the bank with sample accounts and starts the ATM |

| `ATM` | Login, menu and user interaction |

| `Bank` | Stores accounts in a `HashMap` and looks them up by ID |

| `Account` | Balance, PIN check, deposit/withdraw/transfer and transaction history (`ArrayList`) |

| `Transaction` | One transaction record: type, amount, timestamp and details |



\## Sample Accounts

| User ID | PIN | Opening Balance |

|---------|-----|-----------------|

| ACC1001 | 1234 | Rs. 10,000 |

| ACC1002 | 5678 | Rs. 5,000 |

| ACC1003 | 0000 | Rs. 2,500 |



\## Tech Stack

Java 17+, OOP (encapsulation, separation of concerns), `ArrayList`, `HashMap`, `LocalDateTime`



\## How to Run

```bash

javac -d out src/\*.java

java -cp out Main

```



\## Screenshots

!\[Login](screenshots/login.png)

!\[Transactions](screenshots/transactions.png)

!\[Transaction history](screenshots/history.png)



\## Author

Koustav Karmakar – Java Development Intern, Oasis Infobyte

