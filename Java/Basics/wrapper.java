
import java.util.Objects;

// import java.util.Scanner;
// public class wrapper{
//     public static void main(String[] args) {
//         // try(Scanner sc=new Scanner(System.in)){
//             int i =Integer.parseInt(args[0]);
//             double j =Double.parseDouble(args[1]);
//             boolean k =Boolean.parseBoolean(args[2]);
//             System.out.println(i);
//             System.out.println(j);
//             System.out.println(k);
//         // }
//     }
// }

//string and  radix
// public class wrapper{
//     public static void main(String[] args){
//         int i=Integer.parseInt("1000", 2);
//         long l=Long.parseLong("1111", 4);
//         System.out.println(i);
//         System.out.println(l);
//     }
// }


// public class wrapper{
//     public static void main(String[] args){
//         Integer I=new Integer(10);
//         String s=I.toString();
//         System.out.println(s);
//     }
// }


// public class wrapper{
//     public static void main(String[] args){
//         Integer num1=new Integer(10);
//         Integer num2=new Integer(10);
//         Integer num3=new Integer(10);
//         Integer num4=new Integer(10);
//         boolean value1=(num1==num2);
//         boolean value2=(num3==num4);
//         System.out.println(value1);
//         System.out.println(value2);
//     }
// }


public class wrapper{
    public static void main(String[] args){
        Integer num1=5;
        Integer num2=5;
        Integer num3=5;
        Integer num4=5;
        boolean value1=(Objects.equals(num1, num2));
        boolean value2=(num3==num4);
        System.out.println(value1);
        System.out.println(value2);
    }
}
