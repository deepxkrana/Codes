class pack1<T>{
    private T item;
    public T getitem(){
        return item;
    }
    public void setitem(T item){
        this.item=item;
    }
}
public class genericwild{
    public static void deliver(pack1 <?> p){
        System.out.println("Package value is: "+p);
    }
    public static void main(String[] args) {
        pack1<Integer> p=new pack1<>();
        pack1<String> p1=new pack1<>();
        deliver(p);
        deliver(p1);
    }
}
