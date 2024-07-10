public class PalidromeNumberCheckerDemo {
    public static void main(String[] args) {
        int number = 121;
        int sum  = 0 ;
        int rem ;
        int temp = number;
        
        while(number>0)
        {
            rem = number%10;
            sum = (sum*10) + rem;
            number = number/10;
        }


        System.out.println("Orig : " + temp);
        System.out.println("Convertd : " + sum);

        if(temp==sum){
            System.out.println("palidrome Number");
        }else{
            System.out.println("Not palidrome Number");
        }

    }
}
