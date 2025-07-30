import java.time.*;
import java.time.temporal.ChronoUnit;
public class chrono{
    public static void main(String[] args) {
        LocalDate currDate=LocalDate.now();
        LocalDate date1=currDate.plus(5,ChronoUnit.MONTHS);
        System.out.println(date1);
        LocalDate date2=currDate.plus(5,ChronoUnit.DAYS);
        System.out.println(date2);
        LocalDate date3=currDate.minus(5,ChronoUnit.DAYS);
        System.out.println(date3);
        LocalDate date4=currDate.minus(5,ChronoUnit.MONTHS);
        System.out.println(date4);
        System.out.println(date1.isAfter(currDate));
        System.out.println(date1.isBefore(currDate));
        LocalDate currDate1=LocalDate.parse("2025-02-22");
        System.out.println(currDate1.lengthOfMonth());
        System.out.println(currDate1.lengthOfYear());
    }
}
