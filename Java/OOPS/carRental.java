// You are using Java
import java.util.*;
class Vehicle {
   int speed=120;
   Vehicle(){

   }
   void display1(){
       System.out.println("Maximum Speed from Base class (Vehicle): "+speed);
   }
}

class Car extends Vehicle {
    int maxspeed;
    Car(int maxspeed){
        super();
        this.maxspeed=maxspeed;
    }
    void display2(){
        System.out.println("Maximum Speed from Subclass (Car): "+maxspeed);
    }
    void display(){
        display1();
        display2();
    }
}
public class carRental {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){

        int carSpeed = scanner.nextInt();

        Car rentalCar = new Car(carSpeed);


        rentalCar.display();

        scanner.close();
    }
}
}
