public class JaggedArray {
    public static void main(String[] args)
    {
        int nums[][] = new int [3][];
        nums[0] = new int[3];
        nums[1] = new int[4];
        nums[2] = new int[2];

        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums[i].length;j++)
            {
                int random = (int)(Math.random() * 100);
                nums[i][j] = random;
            }
        }

        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums[i].length;j++)
            {
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
