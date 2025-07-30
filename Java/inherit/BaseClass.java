package inherit;
public class BaseClass{
    protected int a;
    public BaseClass(int a){
        this.a=a;
        System.out.println("Base Class Constr called");
    }
    public void set(int a){
        this.a=a;
    }
    public int get(){
        return this.a;
    }
}