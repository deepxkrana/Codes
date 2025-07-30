interface ABC<T>{
    void set(T item);
    T get();
}
public class generic2<T> implements ABC <T>{
    private T content;
    @Override
    public void set(T item){
        this.content=item;
    }
    @Override
    public T get(){
        return content;
    }
    public void display(){
        System.out.println("Content is:"+content);
    }
    public static void main(String[] args) {
        ABC <Integer> a1=new generic2<>();
        a1.set(123);
        System.out.println("integer content "+a1.get());
    }}

