import java.util.*;

public class MultidimentionalArray {
    public static void main(String[] args) {
        Scanner data_reader = new Scanner(System.in);

        int nums [] [] = new int [3] [3];

        

        for(int i=0 ; i<3 ;i++)
        {
            for(int j=0;j<3;j++)
            {
                int row = i + 1;
                int col = j + 1;

                // System.out.print("Enter Value For potition " + row +" , " +col + " : ");
                // int  num = data_reader.nextInt();
                int random = (int)(Math.random() * 100);
                nums[i][j] = random;
            }
        }
        
        System.out.println("\n\n");

        for(int i=0 ; i<3 ;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print( nums[i][j]  + "\t");
            }
            System.out.print("\n");
        }

        for(int n[] : nums)
        {
            for(int m:n)
            {
                System.out.println(m + "\t");
            }

            System.out.println("\n");
        }
    }
}
