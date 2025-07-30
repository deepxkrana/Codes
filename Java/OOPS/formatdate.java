// import java.time.LocalTime;
// import java.time.format.DateTimeFormatter;
// public class formatdate{
//     public static void main(String[] args){
//         LocalDate dt=LocalDate.now();
//         DateTimeFormatter p1=DateTimeFormatter.ofPattern("MM-dd-YY");
//         DateTimeFormatter p2=DateTimeFormatter.ofPattern("MM-YY-dd");
//         System.out.println(p1.format(dt));
//         System.out.println(p2.format(dt));
//         LocalTime c1=LocalTime.now();
//         DateTimeFormatter p3=DateTimeFormatter.ofPattern("s-m-HH");
//         System.out.println(p3.format(c1));
//     }
// }


// class formatdate{
//     public static void main(String[] args){
//         try(Scanner sc=new Scanner(System.in)){
//             int year=sc.nextInt();
//             int month=sc.nextInt();
//             int day=sc.nextInt();
//             int year2=sc.nextInt();
//             int month2=sc.nextInt();
//             int day2=sc.nextInt();
//             LocalDate c0=LocalDate.of(year,month,day);
//             LocalDate c1=LocalDate.of(year2+1,month2,day2);
//             Period p1=Period.between(c0, c1);
//             System.out.println(p1.getDays()+" "+p1.getMonths());
//         }
//     }
// }

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
class monthday{
    void nextmonth(String date){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate c1=LocalDate.parse(date,formatter);
        LocalDate c2=c1.plusMonths(7);
        // System.out.println(c2);
        LocalDate c3=c2.withDayOfMonth(c2.lengthOfMonth());
        System.out.println(c3.lengthOfMonth());
        System.out.println(c3);
        System.out.println(c3.format(formatter));
    }
}
public class formatdate{
    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)){
           String date=sc.nextLine();
           monthday m1=new monthday();
           m1.nextmonth(date);
        }
    }
}
