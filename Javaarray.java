
public class Javaarray {
    public static void main(String[] args) {
        int nums[] = {3,1,4,22,5,9};
        nums[2] = 87;
        int array_length = nums.length;

        for(int i=0;i<array_length;i++)
        {
            int counter = i +1;
            System.out.println("Number " + counter + " : " + nums[i]);
        }
        
    }
}
