import java.util.*;
public class arr1{
    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)){
            // int n=sc.nextInt();
            // java.util.Scanner sc=new java.util.Scanner(System.in);
            int[] myNum=new int[5];
            for(int i=0;i<myNum.length;i++){
                myNum[i]=sc.nextInt();
            }
            for(int i=0;i<myNum.length;i++){
                System.out.print(myNum[i]+" ");
            }
        }
    }
}