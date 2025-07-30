class base{
    base(){
        System.out.println("Base class constr called");
    }
    int a(){
        return 0;
    }
}
class derived extends base{
    derived(){
        System.out.println("Derived class constr called");
    }
    int a(){
        return 7;
    }
}
class derived1 extends base{
    derived1(){
        System.out.println("Derived1 class constr called");
    }
    int a(){
        return 8;
    }
}
public class overrride{
    public static void main(String[] args){
        base a;
        a=new derived();
        // derived b=new derived();
        // derived1 c=new derived1();
        System.out.println("Value is "+a.a());
        a=new derived1();
        System.out.println("Value is "+a.a());
        // System.out.println("Value is "+b.a());
        // System.out.println("Value is "+c.a());
    }
}
