import java.io.Serializable;
public class student implements Serializable{
    int id;
    String name;
    public student(int id,String name){
        this.id=id;
        this.name=name;
    }
}
class others extends student implements Serializable{
    int age;
    String gender;
    public others(int id, String name, int age, String gender){
    super(id,name);
    this.age=age;
    this.gender=gender;
    }
}
