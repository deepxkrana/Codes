import java.util.Scanner;
public class perfectnum{
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int num=sc.nextInt();
            int sum=0;
            for(int i=1;i<=num/2;i++){
                if(num%i==0){
                    sum+=i;
                }
            }
            if(sum==num){
                System.out.println(num+" is a perfect Number");
            }
            else{
                System.out.println(num+" is not a perfect Number");
            }
        }
    }
}