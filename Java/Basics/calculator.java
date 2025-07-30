import java.util.Scanner;
public class calculator{
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            int num1=sc.nextInt();
            int num2=sc.nextInt();
            System.out.println("Enter 1 for Addition, 2 for Subtraction, 3 for Multiplication, 4 for Division");
            int choice=sc.nextInt();
            switch (choice) {
                case 1 -> System.out.println(num1+num2);
                case 2 -> System.out.println(num1-num2);
                case 3 -> System.out.println(num1*num2);
                case 4 -> System.out.println(num1/num2);
            }
        }
    }
}