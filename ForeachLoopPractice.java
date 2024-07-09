public class ForeachLoopPractice {
    public static void main(String[] args) {
        int nums[] = {2,3,4,5};

        for(int n: nums)
        {
            System.out.println(n);
        }

        int nums1[][] = new int[3][3];
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1[i].length; j++) {
                int random = (int)(Math.random() * 100);
                nums1[i][j] = random;
            }
        }

        for(int i[]:nums1)
        {
            for(int j:i)
            {

                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
}
