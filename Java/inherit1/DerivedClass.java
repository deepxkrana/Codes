package inherit1;
import inherit.BaseClass;
public class DerivedClass extends BaseClass{
    String name;
    public DerivedClass(String name, int a){
        super(a);
        this.name=name;
        System.out.println("Derived class constr Called");
    }
    public void getname(String name){
        this.name=name;
    }
    public void display(){
        System.out.println("Name is: "+name+" Value of a: "+get());
    }
}