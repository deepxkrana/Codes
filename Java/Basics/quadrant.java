import java.util.Scanner;
public class quadrant{
    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)){
            int x=sc.nextInt();
            int y=sc.nextInt();
            if(x>0 && y>0){
                System.out.println("First Quadrant");
            }
            else if(x<0 && y>0){
                System.out.println("second Quadrant");
            }
            else if(x<0 && y<0){
                System.out.println("Third Quadrant");
            }
            else if(x>0 && y<0){
                System.out.println("Fourth Quadrant");
            }
            else{
                System.out.println("Origin");
            }
        }
    }
}