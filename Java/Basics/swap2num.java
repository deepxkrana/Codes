import java.util.Scanner;
public class swap2num{
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter num1: ");
            int a=sc.nextInt();
            System.out.println("Enter num2: ");
            int b=sc.nextInt();
            int temp=a;
            a=b;
            b=temp;
            System.out.println(a);
            System.out.println(b);
        }
    }
}