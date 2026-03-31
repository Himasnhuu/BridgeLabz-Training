package Week_01.javaMethods.extras;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {
        
        System.out.println("DATE FORMATTING\n");
        
        // get current date
        LocalDate currentDate = LocalDate.now();
        
        // format 1: dd/MM/yyyy
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String format1 = currentDate.format(formatter1);
        System.out.println("Format 1 (dd/MM/yyyy): " + format1);
        
        // format 2: yyyy-MM-dd
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format2 = currentDate.format(formatter2);
        System.out.println("Format 2 (yyyy-MM-dd): " + format2);
        
        // format 3: EEE, MMM dd, yyyy
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        String format3 = currentDate.format(formatter3);
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + format3);

    }
}
