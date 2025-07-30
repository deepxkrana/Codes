import java.util.ArrayList;
import java.util.List;
public class wrapperexample {
    public static void main(String[] args) {
        // Using primitive type
        int primitiveInt = 10;
        
        // Creating an Integer object (wrapper class)
        Integer wrapperInt = Integer.valueOf(primitiveInt);
        
        // Displaying values
        System.out.println("Primitive int: " + primitiveInt);
        System.out.println("Wrapper Integer: " + wrapperInt);
        
        // Autoboxing: Automatically converting primitive to wrapper
        Integer autoBoxedInt = primitiveInt; // This is done automatically
        System.out.println("Autoboxed Integer: " + autoBoxedInt);
        
        // Unboxing: Automatically converting wrapper to primitive
        int unboxedInt = wrapperInt; // This is done automatically
        System.out.println("Unboxed int: " + unboxedInt);
        
        // Using wrapper class with collections
        List<Integer> intList = new ArrayList<>();
        intList.add(wrapperInt); // Adding wrapper object to the list
        
        System.out.println("List of Integers: " + intList);
    }
}
