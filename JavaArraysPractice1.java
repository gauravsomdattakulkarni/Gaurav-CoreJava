import java.util.Arrays;

public class JavaArraysPractice1 {
    public static void main(String[] args) {
        int arr[] = {2,1,44,5,6,777,8,9};

        int arr2[] = {2,1,44,5,6};
        System.out.println("Maximum number form aray is " + Arrays.stream(arr).max().orElse(Integer.MIN_VALUE));

        Arrays.sort(arr);
        
        System.out.println("Ascending " + Arrays.toString(arr));
        


        for(int i =0 ;i<8;i++)
        {
            System.out.println(arr[i]);
        }

        int intKey = 2; 

        System.out.println( 
            intKey + " found at index = "
            + Arrays.binarySearch(arr, intKey)); 


        int[] arr3 = {1, 2, 3,4};
        int[] arr4 = {1, 2, 3, 4};

        int comparisonResult = Arrays.compare(arr3, arr4);
        System.out.println("Integer Arrays on comparison: " + comparisonResult);

        int [] arr_copy = Arrays.copyOf(arr3,10);

        System.out.println("COpy Of Array " + Arrays.toString(arr_copy));
        System.out.println(Arrays.toString(arr3));
    }
}
