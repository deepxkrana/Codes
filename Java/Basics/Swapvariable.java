import java.util.Scanner;
public class Swapvariable{
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int[] swapped=swap(num1,num2);
        System.out.println("After Swapping");
        System.out.println("First: "+swapped[0]);
        System.out.println("Second: "+swapped[1]);
        // sc.close();
        }
    }
    public static int[] swap(int a, int b){
        a=a+b;
        b=a-b;
        a=a-b;
        return new int[]{a,b};
    }
}