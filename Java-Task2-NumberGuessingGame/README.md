\# Java Task 2 – Number Guessing Game



A console-based number guessing game built in Java. The computer picks a random number and the player guesses it, getting "Too High!" or "Too Low!" hints until they are correct or run out of attempts.



\## Features

\- Random number generated at the start of every round

\- \*\*Three difficulty levels\*\*

&#x20; | Level | Range | Attempts |

&#x20; |-------|-------|----------|

&#x20; | Easy | 1–50 | 10 |

&#x20; | Medium | 1–100 | 7 |

&#x20; | Hard | 1–200 | 5 |

\- "Too High!", "Too Low!" or "Correct!" after each guess

\- Attempt counter shown on every guess (`Attempt 3 of 7`)

\- "You Lost!" message revealing the number when attempts run out

\- Play Again option after every round

\- Score tracking across rounds, with a final summary (rounds played, rounds won, best score)

\- Input validation: non-numeric and out-of-range guesses are rejected without using an attempt



\## Project Structure

| File | Responsibility |

|------|----------------|

| `Difficulty.java` | Enum holding each level's range and attempt limit |

| `GameRound.java` | One round: secret number, guess checking, attempt tracking |

| `RoundResult.java` | Record storing a finished round's outcome and its summary line |

| `Main.java` | Menu, input handling, game loop and final summary |



\## Tech Stack

Java 17+ (enums, records, switch expressions), `java.util.Random`, `Scanner`



\## How to Run

```bash

javac -d out src/\*.java

java -cp out Main

```



\## Screenshots

!\[Difficulty selection](screenshots/difficulty.png)

!\[Gameplay](screenshots/gameplay.png)

!\[Game summary](screenshots/summary.png)



\## Author

Koustav Karmakar – Java Development Intern, Oasis Infobyte

