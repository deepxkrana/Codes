import java.util.*;
public class cf155a{
    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            int amazingScore=0;
            int min=arr[0];
            int max=arr[0];
            for(int i=0;i<n;i++){
                if(arr[i]>max){
                    amazingScore++;
                    max=arr[i];
                }
                else if(arr[i]<min){
                    amazingScore++;
                    min=arr[i];
                }
            }
            System.out.println(amazingScore);
        }
    }
}