import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
class serial1{
    public static void main(String[] args) {
        others s1=new others(12,"abc",20,"Male");
        try{FileOutputStream fout=new FileOutputStream("f.txt");
            try (ObjectOutputStream out = new ObjectOutputStream(fout)) {
                out.writeObject(s1);
                out.flush();
                out.close();
            }
        }
        catch(IOException e){
        }
    }
}
