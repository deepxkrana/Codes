// nano digits are displayed in 3,6,9 digit format else its error
// import java.time.LocalTime;
// public class time{
//     public static void main(String[] args){
//         LocalTime currTime=LocalTime.now();
//         System.out.println(currTime);
//         LocalTime currTime1=LocalTime.of(5,32,30,300);
//         System.out.println(currTime1);
//         LocalTime currTime2=LocalTime.parse("05:32:30.900");
//         System.out.println(currTime2);
//         LocalTime time=currTime.minusHours(1).minusMinutes(10);
//         System.out.println(time);
//     }
// }

// import java.time.*;
// class time{
//     public static void main(String[] args) {
//         LocalTime c1=LocalTime.now();
//         System.out.println("Current Time : "+c1);
//         LocalTime c2=LocalTime.now(ZoneId.of("Asia/Dubai"));
//         System.out.println("Current Time in Dubai is : "+c2);
//         LocalTime c3=LocalTime.now(ZoneId.of("America/Los_Angeles"));
//         System.out.println("Current Time in Los Angeles is : "+c3);
//         LocalTime c4=LocalTime.now(ZoneId.of("Australia/Sydney"));
//         System.out.println("Current Time in Sydney is : "+c4);
//         LocalTime c5=LocalTime.of(10,30,30,200000000);
//         System.out.println("Time c5 : "+c5);
//         LocalTime c6=LocalTime.parse("20:30:30.200000000");
//         System.out.println("Time c6 : "+c6);
//         LocalTime c7=LocalTime.of(14,30,55,500000000);
//         int hour=c7.getHour();
//         int minute=c7.getMinute();
//         int sec=c7.getSecond();
//         int nano=c7.getNano();
//         System.out.println("Hour: "+hour+" Minute: "+minute+sec+nano);
//         System.out.println("is "+c1+" after "+c7+" ?: "+c1.isAfter(c7));
//         System.out.println("is "+c1+" before "+c7+" ?: "+c1.isBefore(c7));
//         LocalDate d1=LocalDate.of(2025,3,26);
//         LocalDateTime d2=c7.atDate(d1);
//         System.out.println("Date Time: "+d2);
//         LocalTime d3=c7.withHour(10);
//         System.out.println("New time is d3: "+d3);
//         LocalTime d4=c7.withMinute(10);
//         System.out.println("New time is d4: "+d4);
//         LocalTime d5=c7.withSecond(10);
//         System.out.println("New time is d5: "+d5);
//         LocalTime d6=c7.withNano(10);
//         System.out.println("New time is d6: "+d6);
//         LocalTime d7=c7.plusHours(10);
//         System.out.println("New time is d7: "+d7);
//         LocalTime d8=c7.plusMinutes(55);
//         System.out.println("New time is d8: "+d8);
//         LocalTime d9=c7.plusSeconds(34);
//         System.out.println("New time is d9: "+d9);
//         LocalTime d10=c7.plusNanos(600000000);
//         System.out.println("New time is d10: "+d10);
//         LocalTime d11=c7.minusHours(10);
//         System.out.println("New time is d11: "+d11);
//         LocalTime d12=c7.minusMinutes(55);
//         System.out.println("New time is d12: "+d12);
//         LocalTime d13=c7.minusSeconds(34);
//         System.out.println("New time is d13: "+d13);
//         LocalTime d14=c7.minusNanos(600000000);
//         System.out.println("New time is d14: "+d14);
//         int d15=c7.getHour();
//         System.out.println("New time is d15: "+d15);
//         int d16=c7.getMinute();
//         System.out.println("New time is d16: "+d16);
//         int d17=c7.getSecond();
//         System.out.println("New time iget: "+d17);
//     }
// }


//write a java prog to get previous and next monday date
// import java.time.*;
// import java.time.temporal.TemporalAdjusters;
// class time{
//     public static void main(String[] args){
//         LocalDate c1=LocalDate.now();
//         System.out.println("Todays Date is: "+c1);
//         System.out.println("Next Monday Date is: "+c1.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
//         System.out.println("Previous Monday Date is: "+c1.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));

//     }
// }


//Write a java program to calculate the difference btw two dates
// import java.time.LocalDate;
// import java.time.Period;
// class time{
//     public static void main(String[] args){
//         LocalDate c0=LocalDate.now();
//         LocalDate c1=LocalDate.of(2025,03,26);
//         Period p1=Period.between(c0,c1);
//         System.out.println("Years "+p1.getYears()+"Months: "+p1.getMonths()+"Days: "+p1.getDays());
//     }
// }


//write a java prog to extract the value of todays date
import java.time.LocalDate;
class time{
    public static void main(String[] args){
    LocalDate c1=LocalDate.now();
    int dd=c1.getDayOfMonth();
    int mm=c1.getMonthValue();
    int yyyy=c1.getYear();
    System.out.printf("%d/%d-%d",dd,mm,yyyy);
    }
}
