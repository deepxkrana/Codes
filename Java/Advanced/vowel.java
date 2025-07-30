import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class vowel{
    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)){
            String text= sc.nextLine();
            char replacement=sc.next().charAt(0);
            FileWriter file=new FileWriter("file1.txt");
            try (BufferedWriter output = new BufferedWriter(file)) {
                String temp=text.replaceAll("[aeiouAEIOU]",String.valueOf(replacement));
                output.write(temp);
            }
        }
        catch(Exception e){
        }
    }
}
