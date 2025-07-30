// import java.util.Stack;
// class stack{
//     public static void main(String[] args) {
//         Stack<Integer> s= new Stack<>();
//         s.push(1);
//         s.push(2);
//         s.push(3);
//         s.push(4);
//         // while(!s.isEmpty()){
//         //     System.err.println(s.pop());
//         // }
//         System.out.println(s.search(1));
//         System.out.println(s.peek());
//         System.out.println(s);
//     }
// }


//Deque
import java.util.*;
class stack{
    public static void main(String[] args) {
        Deque<Integer> d=new ArrayDeque<>();
        d.add(1);
        d.addFirst(2);
        d.addLast(3);
        System.out.println(d);
        d.poll();
        d.pollFirst();
        d.pollLast();
        Iterator i=d.descendingIterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
