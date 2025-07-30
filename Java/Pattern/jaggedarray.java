public class jaggedarray{
    public static void main(String[] args){
        int arr[][]=new int[Integer.parseInt(args[0])][];
        for(int i=0;i<Integer.parseInt(args[0]);i++){
            arr[i]=new int[Integer.parseInt(args[i+1])];
        }
        int count=0;
        for (int[] arr1 : arr) {
            for (int j = 0; j < arr1.length; j++) {
                arr1[j] = count++;
            }
        }
        for (int[] arr1 : arr) {
            for (int j = 0; j < arr1.length; j++) {
                System.out.print(arr1[j] + " ");
            }
            System.out.println();
        }
    }
}