import java.io.*;
import java.util.*;

public class ExpenseTracker {
    private List<Expense> expenses;
    private double totalExpenses;
    private double budget;

    public ExpenseTracker(double budget) {
        this.budget = budget;
        this.expenses = loadExpenses(); // Load previous data if exists
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        totalExpenses += expense.getAmount();
        saveExpenses(); // Save data after each change
    }

    public void removeExpense(Expense expense) {
        expenses.remove(expense);
        totalExpenses -= expense.getAmount();
        saveExpenses();
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<Expense> getExpensesByMonth(int month) {
        List<Expense> filteredExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (Integer.parseInt(expense.getMonth()) == month) {
                filteredExpenses.add(expense);
            }
        }
        return filteredExpenses;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double getRemainingBudget() {
        return budget - totalExpenses;
    }

    public void runCLI() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Expenses by Month");
            System.out.println("4. Export to CSV");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Expense Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    addExpense(new Expense(name, amount));
                    System.out.println("Expense Added!");
                    break;
                case 2:
                    System.out.println("All Expenses:");
                    for (Expense e : expenses) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.print("Enter Month (1-12): ");
                    int month = scanner.nextInt();
                    List<Expense> monthlyExpenses = getExpensesByMonth(month);
                    System.out.println("Expenses for Month " + month + ":");
                    for (Expense e : monthlyExpenses) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    new ExporttoCSV(this).exportToCSV("expenses.csv");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    // Save expenses to file
    private void saveExpenses() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("expenses.ser"))) {
            oos.writeObject(expenses);
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    // Load expenses from file
    private List<Expense> loadExpenses() {
        File file = new File("expenses.ser");
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Expense>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
            return new ArrayList<>();
        }
    }


}
