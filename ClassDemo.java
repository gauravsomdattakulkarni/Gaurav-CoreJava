class Calculator
{
    
    public int add(int num1,int num2)
    {
        int result = num1 + num2;
        return result;
    }

    public int add(int num1 , int num2 , int num3)
    {
        return num1 + num2 + num3;
    }
}

public class ClassDemo {
    public static void main(String[] args) 
    {
        int num1 = 5;
        int num2 = 20;
        
        Calculator calc = new Calculator();

        int result = calc.add(num1,num2);

        System.out.println(result);

        System.out.println(calc.add(12,12,12));
    }
}
