import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Expense implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization

    private String name;
    private double amount;
    private String category;
    private String date; // Stored as timestamp
    private String formattedDate; // Readable format
    private String note;
    private UUID id;

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
        long now = System.currentTimeMillis();
        this.date = String.valueOf(now);
        this.formattedDate = formatDate(now);
        this.id = UUID.randomUUID();
        this.category = "";
        this.note = "";
    }

    private String formatDate(long timestamp) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
    }

    @Override
    public String toString() {
        return "Expense{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", date='" + formattedDate + '\'' +  // Readable date
                ", note='" + note + '\'' +
                ", id=" + id +
                '}' + "\n";
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public String getMonth() {
        return new SimpleDateFormat("MM").format(new Date(Long.parseLong(date)));
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
