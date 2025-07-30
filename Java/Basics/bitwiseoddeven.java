import java.util.Scanner;
public class bitwiseoddeven{
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int x=sc.nextInt();
            System.out.println((Integer.parseInt(args[0])&1==0)?"Even":"Odd");
        }
    }
}