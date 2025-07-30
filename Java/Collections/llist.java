// import java.util.*;
// class llist{
//     public static void main(String[] args) {
//         LinkedList<String> l=new LinkedList<>();
//         l.add("One");
//         l.add("Two");
//         l.add("Three");
//         System.out.println(l);
//         l.add(1,"Six");
//         System.out.println(l);
//         LinkedList<String> l2=new LinkedList<>();
//         l2.add("10");
//         l2.add("20");
//         l.addAll(l2);
//         System.out.println(l);
//         l2.add("600");
//         l.addAll(4,l2);
//         System.out.println(l);
//         l.addFirst("Ten");
//         l.addLast("Zero");
//         System.out.println(l);
//         // l.clear();
//         // System.out.println(l);
//         LinkedList l3=new LinkedList<>();
//         l3=(LinkedList)l.clone();
//         System.out.println(l3);
//         System.out.println(l.contains("Six"));
//         Iterator<String> itr=l.descendingIterator();
//         while(itr.hasNext()){
//             System.out.print(itr.next()+",");
//         }
//         System.out.println(l.element());
//         System.out.println(l.get(5));
//         System.out.println(l.getFirst()+l.getLast());
//         System.out.println(l.peekFirst()+l.peekLast());
//         System.out.println(l.pollLast());
//         System.out.println(l);
//         while(!l.isEmpty()){
//             System.out.print(l.poll()+"<----");
//         }
//     }
// }
//write a program in which we are creating a class and there are two data members int and
//string


import java.util.*;
class obj{
    int num;
    String word;
    public obj(int num, String word){
        this.num=num;
        this.word=word;
    }
    @Override
    public String toString(){
        return "num: "+num+" word: "+word;
    }
}
public class llist{
    public static void main(String[] args){
        LinkedList<obj> l1=new LinkedList<>();
        l1.add(new obj(10,"one"));
        l1.add(new obj(20,"two"));
        Iterator<obj> itr=l1.descendingIterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+",");
        }
    }
}
