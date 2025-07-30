// import java.io.FileInputStream;
// import java.io.FileOutputStream;

// public class image{
//     public static void main(String[] args){
//         try{
//             FileInputStream fis=new FileInputStream("sample1.bmp");
//             FileOutputStream fos=new FileOutputStream("output.bmp");
//             byte[] header=new byte[54];
//             int headerbytereader=fis.read(header);
//             if(headerbytereader!=54){
//                 System.out.println("The file does belong to bmp");
//                 fis.close();
//                 fos.close();
//                 return;
//             }
//             fos.write(header);
//             int bytedata;
//             while((bytedata=fis.read())!=-1){
//                 int modifiedfile=255-bytedata;
//                 fos.write(modifiedfile);
//             }
//             fis.close();
//             fos.close();
//             System.out.println("Image modified");
//         }
//         catch(Exception e){
//             System.out.println(e);
//         }
//     }
// }

// import java.io.*;
// public class image {
//     public static void main(String[] args) {
//         File inputFile = new File("test.txt");
//         File outputFile = new File("test1.txt");

//         try (FileReader reader = new FileReader(inputFile);
//              FileWriter writer = new FileWriter(outputFile)) {

//             char[] array = new char[(int) inputFile.length()];
//             reader.read(array);

//             writer.write(array);
//             writer.flush();

//             System.out.println("File copied successfully!");

//         } catch (IOException e) {
//             System.out.println("An error occurred: " + e.getMessage());
//         }
//     }
// }


import java.io.*;

public class image {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test.txt")) {
            int i;
            while ((i = fis.read()) != -1) {
                int availableBytes = fis.available();
                char c = (char) i;

                System.out.println("Available: " + availableBytes);
                System.out.println("Element: " + c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error: An I/O exception occurred.");
        }
    }
}

