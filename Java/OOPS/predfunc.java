// import java.util.function.*;
// import java.util.*;
// public class predfunc{
//     static void pred(int number,Predicate<Integer> predicate){
//         if(predicate.test(number)){
//             System.out.println(number+number);
//         }
//     }
//     public static void main(String[] args) {
//         try(Scanner sc=new Scanner(System.in)){
//             int num=sc.nextInt();
//             pred(num,(i)->i>7);
//         }
//     }
// }


// import java.util.*;
// import java.util.function.*;
// public class predfunc{
//     static void pred(String name,Predicate<String> predicate){
//         if(predicate.test(name)){
//             System.out.println("The String is empty");
//         } else{
//             System.out.println("Input : "+name);
//         }
//     }
//     public static void main(String[] args) {
//         try(Scanner sc=new Scanner(System.in)){
//             String name=sc.nextLine();
//             pred(name,(i)->i.isEmpty());
//         }
//     }
// }

// import java.util.*;
// interface abc{
//     public String word(String word);
// }
// class predfunc{
//     public static void main(String[] args) {
//         try(Scanner sc=new Scanner(System.in)){
//             String sent=sc.nextLine();
//         }
//     }
// }
