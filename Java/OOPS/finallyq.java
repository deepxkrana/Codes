// class finallyq{
//     public static void main(String[] args) {
//         try{
//             int data=25/0;
//             System.out.println(data);
//             System.exit(data);
//         }
//         // catch(ArithmeticException b){
//         //     System.out.println(b);
//         // }
//         finally{
//             System.out.println("Finally block is always executed");
//         }
//         System.out.println("Rest of the code");
//     }
// }


//throw exception
// class finallyq{
//     public static void validate(int data){
//         if (data<18){
//             throw new ArithmeticException("Value is less than 18");
//         } else{
//             System.out.println("Value is greater than 18");
//         }
//     }
//     public static void main(String[] args){
//         validate(13);
//         System.out.println("Rest of the code");
//     }
// }

// import java.io.*;
// class finallyq{
//     public static void method() throws FileNotFoundException{
//         FileReader file=new FileReader("c:/abc.txt");
//         BufferedReader fileinput= new BufferedReader(file);
//         throw new FileNotFoundException();
//     }
//     public static void main(String[] args){
//         try {
//             method();
//         } catch (FileNotFoundException e) {
//             e.printStackTrace();
//         }
//         System.out.println("Rest of the code");
//     }
// }

class userdefinedException extends Exception{
    public userdefinedException(String str){
        super(str);
    }
}
public class finallyq{
    public static void main(String[] args){
        try {
            throw new userdefinedException("This is userDefined");
        } catch (userdefinedException e) {
            System.out.println("Caught the exception");
            System.out.println(e.getMessage());
        }
    }
}
