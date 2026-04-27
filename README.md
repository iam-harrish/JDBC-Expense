# 💰 Expense Tracker (Java + JDBC + MySQL)

A console-based Expense Tracker application built using Java and JDBC with MySQL database integration.

---

## 🚀 Features

- Add Expense
- View Expenses
- Update Expense
- Delete Expense
- Total Spending Calculation
- Category-wise Summary

---

## 🛠️ Tech Stack

- Java (Core Java)
- JDBC
- MySQL

---

## 📂 Project Structure
Expense-JDBC/
├── src/
│ └── Main.java
├── lib/
│ └── mysql-connector-j-9.7.0.jar
├── schema.sql
└── README.md


---

## ⚙️ Database Setup

Run the following SQL:

sql
CREATE DATABASE expense_tracker;
USE expense_tracker;

CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    category VARCHAR(50),
    amount DOUBLE
);
▶️ How to Run
Compile:
javac -cp "lib/mysql-connector-j-9.7.0.jar" src/Main.java
Run:
java -cp "lib/mysql-connector-j-9.7.0.jar:src" Main

(Windows: use ; instead of :)

📊 Sample Output
ID: 1 | 2026-04-27 | Food | 200.0
ID: 2 | 2026-04-27 | Travel | 500.0
⚡ Future Improvements
Spring Boot REST API
Web UI (Frontend)
User Authentication
Monthly analytics
👨‍💻 Author

Harrish Ragavendrah S


---

# 🔥 STEP 6: After Push (THIS MATTERS)

Do these immediately:

- ⭐ Add repo description  
- 📌 Pin it on your profile  
- 🖼️ Add screenshot of output  

---

# 💣 Brutal truth

Right now you are:
> “Better than beginners”

But not yet:
> “Interview-ready strong candidate”

---

# ⚡ Your next move (don’t stall)

Pick ONE:

- 👉 :contentReference[oaicite:1]{index=1} (best move)
- 👉 :contentReference[oaicite:2]{index=2}
- 👉 :contentReference[oaicite:3]{index=3}

---

If you’re serious, say:
**“convert this to spring boot step by step”**

That’s where your profile actually becomes strong.
