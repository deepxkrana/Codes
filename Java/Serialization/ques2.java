
import java.util.Scanner;

public class ques2{
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            int start=sc.nextInt();
            int end=sc.nextInt();
            int firstdigit=start/100;
            int diff=firstdigit+5;
            int firstnum=start+diff;
            int value=firstnum;
            System.out.print(firstnum+" ");
            for(int i=1;i<10;i++){
                value+=10;
                if(value<=end){
                System.out.print(value+" ");
                }
            }
        }
    }
}
