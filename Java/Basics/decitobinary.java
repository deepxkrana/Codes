import java.util.Scanner;
public class decitobinary{
    public static void main(String[] args){
        try(Scanner sc= new Scanner(System.in)){
        int deci = sc.nextInt();
            String binary=Integer.toBinaryString(deci);
            System.out.println("Binary representation: "+ binary);
        }
    }
}