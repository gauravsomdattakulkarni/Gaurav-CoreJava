public class ThreeDimentionalArray {
    public static void main(String[] args) {
        int nums [][][] = new int[3][3][5];

        for(int i=0 ; i<3 ;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<5;k++)
                {
                    int random = (int)(Math.random() * 100);
                    nums[i][j][k] = random;
                }
            }
        }


        for(int i=0 ; i<3 ;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<5;k++)
                {
                    System.out.print( "["+nums[i][j][k] + "]");
                }
                System.out.print("\t\t");
            }

            System.out.println();
        }


    }
}
