import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class ExporttoCSV {
    private ExpenseTracker expenseTracker;

    public ExporttoCSV(ExpenseTracker expenseTracker) {
        this.expenseTracker = expenseTracker;
    }

    public void exportToCSV(String filename) {
        List<Expense> expenses = expenseTracker.getExpenses();
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Name,Amount,Category,Date,Note\n");
            for (Expense expense : expenses) {
                sb.append(expense.getName()).append(",");
                sb.append(expense.getAmount()).append(",");
                sb.append(expense.getCategory()).append(",");
                sb.append(expense.getFormattedDate()).append(",");
                sb.append(expense.getNote()).append("\n");
            }
            writer.write(sb.toString());
            System.out.println("Expenses exported to: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error exporting CSV: " + e.getMessage());
        }
    }
}
