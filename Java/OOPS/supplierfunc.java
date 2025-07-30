// import java.util.function.*;
// public class supplierfunc{
//     public static void main(String[] args) {
//         Supplier<Double> randomValue=()->Math.random();
//         System.out.println(randomValue.get());
//     }
// }


//OTP Generator
import java.util.Random;
import java.util.function.*;
public class supplierfunc{
    public static void main(String[] args) {
        Supplier<String> otpSupplier=()->{
            Random random = new Random();
            return String.format("%06d",random.nextInt(1000000));
        };
        System.out.println(otpSupplier.get());
    }
}
