import java.util.Scanner;
public class ap{
    public static void main(String[] args){
        try(Scanner sc= new Scanner(System.in)){
            int n=sc.nextInt();
            // for(int i=1;i<=(2*n-1);i+=2){
            //     System.out.print(i+" ");
            // }
            int a=4,d=3;
            for(int i=1;i<=n;i++){
                System.out.print(a+" ");
                a+=d;
            }
        }
    }
}