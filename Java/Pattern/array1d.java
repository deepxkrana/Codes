
import java.util.Arrays;

public class array1d{
    public static void main(String[] args){
        int[][] arr1={{1,2},{3,4}};
        int[][] arr2={{1,2},{3,4}};
        System.out.println(Arrays.deepEquals(arr1,arr2));
    }
}