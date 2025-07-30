import java.io.*;

public class statictest implements Serializable{
    static int x=10;
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        statictest s1=new statictest();
        System.out.println("Before serialaization x value is: "+x);
        try{FileOutputStream fout=new FileOutputStream("f1.txt");
            try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
                out.writeObject(s1);
                out.flush();
                out.close();
                x=20;
                ObjectInputStream in=new ObjectInputStream(new FileInputStream("f1.txt"));
                statictest s=(statictest)in.readObject();
                System.out.println("After Serialization x value is: "+s.x);
                in.close();
            }
        } catch(IOException | ClassNotFoundException e ){
            e.printStackTrace();
        }
    }
}
