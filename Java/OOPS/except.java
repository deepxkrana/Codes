// package pack1.pack2;
// class except{
//     public static void main(String[] args) {
//         int x=10;
//         assert(x<20):"Hello world";
//         System.out.println(x);
//     }
// }
//-ea enable assetion for non system classes
//-da disable assertion for non system classes
//-esa enable assertion for system classes
//-dsa disable assertion for system classes

// import java.util.Scanner;

// public class except {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             int day=sc.nextInt();
//             assert (day>=1 && day<=7):"Invalid input";
//             switch(day) {
//                 case 1 -> System.out.println("Monday");
//                 case 2 -> System.out.println("Tuesday");
//                 case 3 -> System.out.println("Wednesday");
//                 case 4 -> System.out.println("Thursday");
//                 case 5 -> System.out.println("Friday");
//                 case 6 -> System.out.println("Saturday");
//                 case 7 -> System.out.println("Sunday");
//                 default -> System.out.println("Default case executed.");
//             }
//         }
//     }
// }

// import java.util.*;
// class except{
//     static int x=6;
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             int  x=sc.nextInt();
//             assert m1();
//             System.out.println(x);
//         }
//     }
//     public static boolean  m1(){
//         x=6;
//         return false;
//     }
// }


//exception
//main is a default thread
//a separate stack is created for a thread. then all the methods are pushed inside the
//stack one by one
//ArithmaticException
//NullPointerException
//NumnberFormatException

// class except {
//     public static void main(String[] args) {
//         int[] num = {1, 2, 3, 4, 5};
//         String str = null;
//         String str1 = "abc";

//         System.out.println("Statement 1");

//         // Handling ArrayIndexOutOfBoundsException
//         try {
//             int index = 10;
//             int value = num[index]; // This will cause an exception
//             System.out.println(value);
//         } catch (ArrayIndexOutOfBoundsException a) {
//             System.out.println("ArrayIndexOutOfBoundsException caught.");
//         }

//         // Handling NullPointerException
//         try {
//             int length = str.length();  // Trying to access length of null
//             System.out.println(length);
//         } catch (NullPointerException b) {
//             System.out.println("NullPointerException caught.");
//         }

//         // Handling ArithmeticException (Division by Zero)
//         try {
//             System.out.println(10 / 0);  // This will cause ArithmeticException
//         } catch (ArithmeticException c) {
//             System.out.println("ArithmeticException caught.");
//         }

//         // Handling NumberFormatException (Invalid string-to-integer conversion)
//         try {
//             int numval = Integer.parseInt(str1); // Trying to convert "abc" to an integer
//             System.out.println(numval);
//         } catch (NumberFormatException d) {
//             System.out.println("NumberFormatException caught.");
//         }

//         System.out.println("Statement 3");
//     }
// }

class except{
    public static void main(String[] args){
        try{
            int a=10,b=0,c;
            c=a/b;
            System.out.println(c);
            int[] arr={10,20,30};
            System.out.println(arr[1]);
            String str=null;
            System.out.println(str.toUpperCase());
        }
        catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Array Exception");
        }
        catch(ArithmeticException b){
            System.out.println("Arithmetic exception");
        }
        catch(NumberFormatException c){
            System.out.println("Number format exception");
        }
        catch(Exception d){
            System.out.println("Other exception");
        }
    }
}
