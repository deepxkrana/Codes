// import java.util.function.*;
// class consumerfunc{
//     public static void main(String[] args) {
//         Consumer<String> consumer =(t)->System.out.println("The passed parameter is: "+t);
//         consumer.accept("hello world");
//     }
// }

import java.util.function.*;
class consumerfunc{
    public static void main(String[] args) {
        int list[]={1,2,3,4};
        Consumer<Integer> consumer =(Integer x)->System.out.println(x);
        doq(list, consumer);
    }
    static void doq(int[] list, Consumer<Integer> consumer){
        for(int t:list){
            consumer.accept(t);
        }
    }
}
