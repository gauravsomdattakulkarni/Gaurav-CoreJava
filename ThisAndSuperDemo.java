class A
{
    public A()
    {
        System.out.println("In A");
    }

    public A(int n) 
    {
        System.out.println("In A N");
    }
}

class B extends A
{
    public B() 
    {
        System.out.println("In B");
    }

    public B(int n) 
    {
        System.out.println("In B N");
    }
}

public class ThisAndSuperDemo {
    public static void main(String[] args) {
        B ob1 = new B(12);
    }
}
