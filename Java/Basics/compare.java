import java.util.Scanner;
public class compare{
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            if(a>b && a>c){
                System.out.println(a+" is largest number");
            }
            if(b>a && b>c){
                System.out.println(b+" is largest number");
            }
            else{
                System.out.println(c+" is largest number");
            }
        }
    }
}