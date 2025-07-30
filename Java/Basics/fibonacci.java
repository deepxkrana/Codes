import java.util.Scanner;
public class fibonacci{
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            int num=sc.nextInt();
            if(num<=0){
                System.out.println("Enter a positive Number");
            }
            else if(num==1){
                System.out.println("Fibonacci Sequence up to "+num+" is:");
                System.out.println("0");
            }
            else{
                System.out.println("Fibonacci Sequence up to "+num+" is:");
                int first =0, second =1;
                System.out.print(first+" "+second);
                for(int i=3;i<=num;i++){
                    int next=first+second;
                    System.out.print(" "+next);
                    first=second;
                    second=next;
                }
            }
        }
    }
}