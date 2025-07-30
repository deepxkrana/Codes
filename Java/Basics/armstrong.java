import java.util.Scanner;
public class armstrong{
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            int num= sc.nextInt();
            int original=num;
            int sum=0;
            int digits=0;
            while(num!=0){
                num/=10;
                digits++;
            }
            num=original;
            while(num!=0){
                int digit=num%10;
                sum+=Math.pow(digit, digits);
                num/=10;
            }
            if(sum==original){
                System.out.println(original+ " is an Armstrong Number");
            }
            else{
                System.out.println(original+" is not an Armstrong Number");
            }
        }
    }
}