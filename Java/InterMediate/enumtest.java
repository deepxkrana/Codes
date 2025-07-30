// import java.util.Scanner;
public class enumtest{
    public enum Days{
         MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
    }
    Days day;
    public enumtest(Days day1){
        this.day=day1;
    }
    public void abc(){
        switch(day){
            case MONDAY -> System.out.println("Hello MONDAY");
            case WEDNESDAY -> System.out.println("Hello WEDNESDAY");
            case SATURDAY -> System.out.println("Hello SATURDAY");
            case SUNDAY -> System.out.println("Hello SUNDAY");
        }
    }
    public static void main(String[] args) {
        enumtest obj = new enumtest(Days.MONDAY);
        obj.abc();
    }
} 