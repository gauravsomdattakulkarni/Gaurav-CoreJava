class A
{
    public A()
    {
        System.out.println("Object Creared");
    }

    public void show()
    {
        System.out.println("Show Method");
    }
}
public class AnonymusObjecr {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();

        new A();
    }
}
