import java.util.function.*;
public class fncint{
        public static void main(String[] args){
            // Function<Integer, Double> f=(i)->i/2.0;
            // BiFunction<Integer,Integer,Integer> f=(i,j)->i*j;
            // Function<Integer,Double> f=(i)->i/2.0;
            // f=f.andThen(i->i+3);
            // Function<Integer,Double> f=(i)->i/2.0;
            // f=f.compose(i->i+3);
            // Function<Integer,Integer> f=Function.identity();
            // System.out.println(f.apply(20));
            // Predicate<Integer> f=i->i%2!=0;
            // boolean result=f.test(20);
            // System.out.println(result);
            Predicate<Integer> g=(i)->i>10;
            Predicate<Integer> l=(i)->i<20;
            boolean result=g.and(l).test(15);
            System.out.println(result);
            boolean result1=g.and(l).test(20);
            System.out.println(result1);
            boolean result2=g.and(l).negate().test(20);
            System.out.println(result2);
    }
}
