package static_methods.date_format_utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Interface with static method for date formatting
public interface DateFormatter {
    
    static String formatDate(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }
    
    static String formatAsISO(LocalDate date) {
        return formatDate(date, "yyyy-MM-dd");
    }
    
    static String formatAsUS(LocalDate date) {
        return formatDate(date, "MM/dd/yyyy");
    }
    
    static String formatAsEU(LocalDate date) {
        return formatDate(date, "dd/MM/yyyy");
    }
}
