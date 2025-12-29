package Week_01.javaMethods.extras;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeZonesDisplay {
    public static void main(String[] args) {
        
        System.out.println("CURRENT TIME IN DIFFERENT TIME ZONES.\n");
        
        // get current time in GMT
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        
        // get current time in IST
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        
        // get current time in PST
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        
        // format pattern for display
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        
        // display times
        System.out.println("GMT (Greenwich Mean Time):");
        System.out.println(gmtTime.format(formatter));
        
        System.out.println("\nIST (Indian Standard Time):");
        System.out.println(istTime.format(formatter));
        
        System.out.println("\nPST (Pacific Standard Time):");
        System.out.println(pstTime.format(formatter));
        
    }
}
