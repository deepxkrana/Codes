import java.io.*;
import java.util.Scanner;
public class wordswap{
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in); PrintWriter writer = new PrintWriter(System.out)){
            int n=sc.nextInt();
            sc.nextLine();
            String[] text=sc.nextLine().split(" ");
            for(int i=0;i<n;i+=2){
                writer.print(text[i+1]+" "+text[i]+" ");
            }
            writer.flush();
            sc.close();
        }
        catch(Exception e){
        }
    }
}
