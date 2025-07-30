// class Student{
//     int roll;
//     String name;
// }
// public class test1{
//     public static void main(String[] args){
//         Student s1=new Student();
//         s1.roll=15;
//         s1.name="Rohan";
//         System.out.println(s1.name);
//         System.out.println(s1.roll);
//     }
// }
import java.util.*;
class Algebra{
    int add(int a, int b){
        int sum=a+b;
        return sum;
    }
}
public class test1{
    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)){
            int a=sc.nextInt();
            int b=sc.nextInt();
            Algebra obj=new Algebra();
            // obj.add(a,b);
            System.out.println(obj.add(a,b));
        }
    }
}
