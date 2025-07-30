import java.io.FileInputStream;
import java.io.ObjectInputStream;

class deserial1{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args){
        try(FileInputStream fin=new FileInputStream("f.txt");
        ObjectInputStream in=new ObjectInputStream(fin)){
            others s1=(others)in.readObject();
            in.close();
            System.out.println(s1.id+" "+s1.name+" "+s1.age+" "+s1.gender);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
