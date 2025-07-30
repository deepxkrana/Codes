@FunctionalInterface
interface F1{
    void sq(int a);
    // int sq1(int b);
}
public class funcinterface{
    public static void main(String[] args) {
        F1 obj=(a)->{
            if (a%2==0){
            System.out.println("even");
            // return 1;
            }
            else{
            System.out.println("odd");
            // return 0;
            }
            };
        obj.sq(5);
    }
}
