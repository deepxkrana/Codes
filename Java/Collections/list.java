
import java.util.LinkedList;

// //Upper bounded WildCards

// import java.util.*;
// class list{
//     public void print(List <? extends Number> l){
//         for(Number n:l){
//             System.out.println(n);
//         }
//         l.add(5);
//     }
//     public static void main(String[] args) {
//         list obj=new list();
//         List<Integer> l1= Arrays.asList(1,2,3);
//         List<Float> l2= Arrays.asList(1.2f,1.3f,1.4f);
//         obj.print(l1);
//         obj.print(l2);
//     }
// }

//Lower bounded WildCards

// import java.util.*;
// class list{
//     public static void adddata(List <? super Integer> l){
//         // for(Object n:l){
//         //     System.out.println(n);
//         // }
//         l.add(5);
//         l.add(65);
//         l.add(90);
//         // for(Object n:l){
//         //     System.out.println(n);
//         // }
//     }
//     public static void main(String[] args) {
//         List<Number> l1=new ArrayList<>();
//         List<Object> l2=new ArrayList<>();
//         adddata(l1);
//         adddata(l2);
//         System.out.println(l1);
//         System.out.println(l2);
//     }
// }

// import java.util.*;
// class list{
//     public static void main(String[] args) {
//         ArrayList<Integer> a1=new ArrayList<>();
//         a1.add(10);
//         a1.add(20);
//         a1.add(30);
//         System.out.println(a1);
//         int i=2;
//         a1.add(i,21);
//         System.out.println(a1);
//         a1.remove(3);
//         System.out.println(a1);
//         a1.add(1);
//         a1.add(2);
//         System.out.println(a1);
//         a1.remove(Integer.valueOf(1));
//         System.out.println(a1);
//         Iterator itr=a1.iterator();
//         while(itr.hasNext()){
//             int x=(Integer) itr.next();
//             if(x<10){
//                 itr.remove();
//             }
//         }
//         System.out.println(a1);
//         int r=a1.set(2,90);
//         System.out.println(a1);
//         System.out.println(r);
//     }
// }


// import java.util.*;
// class list{
//     public static void main(String[] args) {
//         ArrayList<Integer> a1=new ArrayList<>();
//         a1.add(10);
//         a1.add(20);
//         a1.add(10);
//         a1.add(30);
//         a1.add(40);
//         a1.add(20);
//         a1.add(30);
//         System.out.println(a1);
//         Set<Integer> seen=new HashSet<>();
//         Iterator<Integer> itr=a1.iterator();
//         while(itr.hasNext()){
//             int x=itr.next();
//             if(seen.contains(x)){
//                 itr.remove();
//             }else{
//                 seen.add(x);
//             }
//         }
//         System.out.println(a1);
//         Collections.reverse(a1);;
//         System.out.println(a1);
//    }
// }


