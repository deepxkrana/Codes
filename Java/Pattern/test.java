import java.util.Scanner;
public class test{
    public static void main(String[] args){
        String ss=null;
        String fName=null;
        try(Scanner sc=new Scanner(System.in)){
        while(sc.hasNext()){
            ss=sc.next();
            fName=sc.next();
            System.out.println(ss+fName);
                }
            }
        }
    }