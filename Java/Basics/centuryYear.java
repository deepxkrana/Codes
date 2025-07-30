import java.util.Scanner;
public class centuryYear{
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            int year=sc.nextInt();
            if(year%100==0){
                    System.out.println(year+" is a century year");
            }
            else{
                    System.out.println(year+" is not a century year");
                }
        }
    }
}