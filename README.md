# simpleExpenseTracker-cli
# Expense Tracker CLI

## 📌 Overview
This is a **Command Line Interface (CLI)** application for tracking expenses. Users can **add, update, delete, and view expenses**, as well as **export expense data to CSV files**. The application also supports **monthly expense filtering** and **persistent storage** using serialization.

## 🔧 Features
- ✅ **Add an Expense** (with a name, amount, category, and optional note)
- ✅ **Update an Expense**
- ✅ **Delete an Expense**
- ✅ **View All Expenses**
- ✅ **View Expenses for a Specific Month**
- ✅ **Export Expenses to CSV**
- ✅ **Persistent Storage** (Saves and Loads Expenses)

## 🚀 Installation & Setup
### Prerequisites:
- Java 8+ installed
- A terminal or command prompt

### Steps to Run:
1. **Clone this repository**
   ```sh
   git clone https://github.com/tjothiprakash/expense-tracker-cli.git
   cd expense-tracker-cli
   ```
2. **Compile the project**
   ```sh
   javac *.java
   ```
3. **Run the application**
   ```sh
   java ExpenseTracker
   ```

## 📜 Usage
Once the application starts, you will see a menu like this:
```
Expense Tracker Menu:
1. Add Expense
2. View All Expenses
3. View Expenses by Month
4. Export to CSV
5. Exit
Choose an option:
```
### Example Actions:
- **Adding an Expense**
    - Enter Name: `Lunch`
    - Enter Amount: `12.50`
- **Viewing Expenses by Month**
    - Enter month: `2` → Displays all expenses from February
- **Exporting to CSV**
    - The expenses will be saved in `expenses.csv`

## 🛠 Project Structure
```
📂 expense-tracker-cli
 ├── Expense.java         # Represents an expense
 ├── ExpenseTracker.java  # Main class (handles user interactions)
 ├── ExporttoCSV.java     # Handles CSV export
 ├── expenses.ser         # (Auto-generated) Persistent storage file
 ├── expenses.csv         # (Generated) CSV file for exporting
 └── README.md            # Project documentation
```

## 📝 Future Enhancements
- 📊 Add **category-based expense tracking**
- 🔔 Set **budget alerts** for overspending
- 📈 Generate **monthly reports**

## 📄 License
This project is open-source and available under the **MIT License**.

---
**Happy Coding! 😊**
https://github.com/TJothiprakash/simpleExpenseTracker-cli
https://roadmap.sh/projects/expense-tracker

