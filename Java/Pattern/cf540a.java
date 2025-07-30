import java.util.*;
public class cf540a{
    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)){
            int n=sc.nextInt();
            int[] disk= new int[sc.nextInt()];
            for(int i=0;i<disk.length;i++){
                disk[i]=sc.nextInt();
            }
            int[] pass= new int[sc.nextInt()];
            for(int i=0;i<pass.length;i++){
                pass[i]=sc.nextInt();
            }
            int moves=0;
            for(int i=0;i<n;i++){
                int diff=Math.abs(disk[i]-pass[i]);
                moves+=Math.min(diff, 10-diff);
            }
            System.out.println(moves);
        }
    }
}