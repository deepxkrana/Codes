import java.util.Scanner;
public class absolute{
    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)){
            int n=sc.nextInt();
            if(n<0){
                int num=n*(-1);
                System.out.println(num);
            }
            else{
                System.out.println(n);
            }
        }
    }
}