import java.util.Scanner;
class instance {
    static class CustomClass {
        void displayMessage(String name){
            System.out.println("CustomClass: Hey, "+name+"! Nice to meet you");
        }
        boolean isInstanceOfClass(Object obj){
            return obj instanceof CustomClass;
        }
    }
public static void main(String[] args) {
    try(Scanner sc=new Scanner(System.in)){
        String name=sc.nextLine();
        boolean isStringInstance=name instanceof String;
        System.out.println("Name is an instance of String: "+isStringInstance);
        int userNumber=sc.nextInt();
        double squareroot=Math.sqrt(userNumber);
        System.out.printf("Square root of the entered number: %.2f%n",squareroot);
        CustomClass obj=new CustomClass();
        obj.displayMessage(name);
        boolean isCustomClassInstance=obj.isInstanceOfClass(obj);
        System.out.println("customObj is an instance of CustomClass: "+isCustomClassInstance);
        }
    }
}
