class Demo1
{
    public void show()
    {
        System.out.println("In Show Of A");
    }

    public void config()
    {
        System.out.println("Configuration Of A");
    }
}

class Demo2 extends Demo1
{
    public void show()
    {
        System.out.println("In Show Of B");
    }
}
public class MethodOverridingDemo
{
    public static void main(String[] args) {
        Demo2 d1 = new Demo2();
        d1.show();
        d1.config();
    }
}