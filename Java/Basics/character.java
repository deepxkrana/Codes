import java.util.Scanner;
public class character{
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            char ch= sc.next().charAt(0);
            if(Character.isLetter(ch)){
                System.out.println(ch+" is an Alphabet");
            }
            else if(Character.isDigit(ch)){
                System.out.println(ch+" is an Digit");
            }
            else{
                System.out.println(ch + " is a special character");
            }
        }
    }
}