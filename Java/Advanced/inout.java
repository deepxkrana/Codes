// import java.io.FileOutputStream;
// import java.io.IOException;
// public class inout{
//     public static void main(String[] args){
//         try{
//             FileOutputStream fout=new FileOutputStream("test.dat",true);
//             String s="Hello Lovely Professional University";
//             // byte[] array={65,66,67,68,69,70,71,72,73,74};
//             // byte[] b=s.getBytes();
//             byte[] array=s.getBytes();
//             fout.write(array,13,12);
//             fout.close();
//             System.out.println("File Created");
//         }
//         catch(IOException e){
//             System.out.println(e);
//         }
//     }
// }

// import java.io.*;
// public class inout{
//     public static void main(String[] args){
//         File f1=new File("test.txt");
//         if(f1.exists()){
//             System.out.println("File exists at path"+f1.getAbsolutePath());
//         } else{
//             System.out.println("File not found");
//         }
//     }
// }


// import java.io.*;
// public class inout{
//     public static void main(String[] args){
//         FileOutputStream fos=null;
//         FileInputStream fis=null;
//         FileDescriptor fd=null;
//         boolean bool=false;
//         try {
//             fos=new FileOutputStream("/Users/deepakrana/Desktop/VS Code/Java/Advanced/test.txt");
//             fd=fos.getFD();
//             System.out.println(fd);
//             bool=fd.valid();
//             System.out.println("Is File valid? "+bool);
//         } catch (IOException e) {
//             System.out.println(e);
//         }
//     }
// }

import java.io.*;
public class inout{
    public static void main(String[] args){
        try{
            FileOutputStream fout1=new FileOutputStream("test.txt",true);
            String s="Hello World";
            fout1.write(s.getBytes());
            fout1.close();
            System.out.println("Source text Copied");
            FileInputStream fin=new FileInputStream("test.txt");
            FileOutputStream fout=new FileOutputStream("new.txt",true);
            int i;
            while((i=fin.read())!=-1){
                fout.write((char)i);
            }
            fin.close();
            fout.close();
            System.out.println("Data copied");
        } catch(IOException e){
            System.out.println(e);
        }
    }
}
