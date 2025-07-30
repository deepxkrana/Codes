public class generic<A,T>{
    private T t;
    private A b;
    public void add(T t,A b){
        this.t=t;
        this.b=b;
    }
    public T get(){
        return t;
    }
    public A get1(){
        return b;
    }
    public static void main(String[] args) {
        generic <Float,Integer> g1=new generic<>();
        g1.add(5,10.10f);
        System.out.println(g1.get());
        System.out.println(g1.get1());
        generic<String,Double> g2=new generic<>();
        g2.add(5.44,"hello");
        System.out.println(g2.get());
        System.out.println(g2.get1());
    }
}
