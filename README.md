# YoloTrader

## About
YoloTrader is a stock analysis service targeted to retail Investors. It offers stock price tracking,
current stock related news articles, stock organization, and houses artificial intelligence 
framework that analyzes stocks on user request. YoloTrader supports all stocks listed on 
NYSE and NASDAQ, as well as their market indexes.



#### Contributors:
- Owen Murphy
- Prince Kalu

PC: [artbykenb](https://www.instagram.com/artbykenb/?igshid=x6h2dqgrhdwc)
![](Images/owen_and_prince.jpeg)

---

## Project Summary

YoloTrader is a Java desktop application (Swing GUI) that helps retail investors keep track of stocks they care about, read related news, and get a simple buy/sell/hold suggestion for a given stock. It was built as a team project for Baylor's CSI 3471 (Software Engineering) course, developed over three iterations (requirements and domain model, design model and sequence diagrams, then implementation).

Users create an account, log in, search for companies listed on NYSE or NASDAQ, organize stocks into personal watch lists, and open a detail page for any stock showing its intraday chart, quote, news, and an automated analysis.

## Features

### Accounts and Security
- **Create account** with first name, last name, username, email, and password (with re-entry confirmation).
- **Email validation**: email format is checked, must be unique, and a one-time verification code is emailed to the user (3 attempts allowed) before the account is created.
- **Log in / log out** using email and password.
- **Forgot password**: a new random password is generated and emailed to the user.
- **Profile page**: view and edit first name, last name, username, and email; change password; delete account (password confirmation required).

### Home Dashboard
- **Today's Best Performing Stocks** and **Today's Worst Performing Stocks**: scrollable feeds of top gainers and losers. Clicking a tile opens that stock's page.
- **Market Indicators**: intraday price graphs for the DIA (Dow Jones) and NDAQ (Nasdaq) indexes.
- **Trending News**: scrollable feed of general market news with images; headlines open the full article in the user's browser.

### Stock Search and Watch Lists
- **Search** for a stock by company name or ticker (NYSE and NASDAQ), with a results dialog to add or open a stock.
- **Watch lists**: create, rename, and delete named watch lists.
- **Add and remove stocks** in a watch list, with duplicate detection.
- **Right-click menus** on watch lists and stocks for quick open, rename, and delete actions.
- Each stock records the date it was added.

### Stock Page
- **Intraday price graph** (30-minute intervals, 9:30 AM to 4:00 PM), drawn in green if the day is up and red if it is down.
- **Daily quote** details from Yahoo Finance.
- **Analysis**: a Buy/Calls, Sell/Puts, or Hold/Watch recommendation (see below).
- **Daily news** specific to the stock.
- Multiple stocks open as tabs in a single window.

### Help and About
- Built-in Help and About sections, plus a Help dialog on the login screen with the company contact email.

## How the Analysis Works

1. For a requested stock, the app pulls the last 14 days of 10-period Double Exponential Moving Average (DEMA) values and trading volume from the Financial Modeling Prep API.
2. Each day's volume is counted as buying pressure if the DEMA is below the current price, or selling pressure if it is above.
3. If one side exceeds the other by 40% or more, the app suggests **Buy/Calls** or **Sell/Puts**. Otherwise it suggests **Hold/Watch**.
4. **Self-evaluation**: each non-hold prediction is saved (`predictions.txt`) and checked later. A prediction counts as correct if the price moves 5% in the predicted direction, and as wrong if that has not happened within about two weeks. Running right/wrong totals are kept in `confidence.txt`.
5. If overall accuracy falls below 50%, the app flips its recommendation (Buy becomes Sell and vice versa).

> **Disclaimer:** the analysis is a simple educational heuristic and not financial advice.

## Architecture

The prototype follows a layered design:

| Layer | Package | Responsibility |
|---|---|---|
| Presentation (UI) | `presentation.UI.form`, `presentation.UI.mainPage`, `presentation.UI.stockPage` | Swing screens: login/create account/help forms, main frame (north search/welcome bar, west navigation, center pages), graph, news, and feed panels |
| Presentation logic | `presentation.presentationLogic` | Controllers (`ProfileController`, `StockController`, `StockWatchListController`, `CommentController`) that connect UI events to services |
| Service | `service` | Business rules (`ProfileService`, `StockService`, `StockWatchListService`, `CommentService`) |
| DAO | `dao` | `GenericDAO<T>` interface with `ProfileDAO` and `StockWatchListDAO` implementations |
| Model | `model` | `Profile`, `StockWatchList`, `Stock`, `Comment` (JAXB-annotated) |
| API / Util | `API`, `util` | `StockUtil` (market data, news, graphs, analysis) and `XMLProfileDAOUtil` (XML persistence) |
| Entry point | `main` | `YoloTrader` (logging setup, AI update, app launch) |

## Tech Stack

- **Language / build**: Java 9+, Maven
- **GUI**: Java Swing / AWT, with a custom-drawn `GraphPanel`
- **Market data**: [Yahoo Finance API](https://github.com/sstrickx/yahoofinance-api) (quotes, stock lookup) and [Financial Modeling Prep](https://financialmodelingprep.com/) (search, intraday charts, news, gainers/losers, technical indicators)
- **Persistence**: XML file (`database.xml`) using JAXB marshalling and unmarshalling
- **Email**: JavaMail (SMTP) for verification codes and password recovery
- **Validation**: Apache Commons Validator and Commons Lang
- **Logging**: `java.util.logging` configured by `logger.properties`
- **Testing**: JUnit 5 (`ProfileTest`)

## Getting Started

```bash
cd Prototype
mvn compile
```

Then run `YoloTrader.class` (main class `edu.baylor.ecs.csi3471.main.YoloTrader`) from your IDE, such as IntelliJ. The Yahoo Finance and commons-validator JARs are expected under `target/plugins/`.

Notes:
- Run the app from the `Prototype` directory, since the XML database and resource files are read using relative paths.
- You will need your own Financial Modeling Prep API key(s) and SMTP credentials for the news, market data, and email features.

## Repository Layout

```
YoloTrader/
├── Iteration1/   Requirements, domain model, use cases, SSDs, wireframes, schedule
├── Iteration2/   Design model, sequence diagrams, system operations
├── Iteration3/   Revised design/requirements, time logs, final presentation
└── Prototype/    Maven project (src/main, src/test, database.xml, pom.xml)
```

## Known Limitations and Future Work

- **Comments on stocks**: the `Comment` model and UI exist, but the feature is disabled (it caused UI lag) and `CommentService` is unimplemented.
- **Security**: passwords are stored in plain text in `database.xml`, and API keys and email credentials are hardcoded in source. These should move to hashed passwords and external configuration or environment variables before any real use.
- **Planned features** from the Iteration 1 documents, such as private messaging and finding friends, were not built.
- The Help section's FAQ and "What Are Stocks?" content is still a placeholder.
- Test coverage is minimal, and the `ProfileTest` assertions are currently commented out.
