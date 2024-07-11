

class Human
{
    private int age;
    private String name;

    public Human()
    {
        System.out.println("In Constructor");
    }
    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}

public class EncapsulatitonDemo {
    public static void main(String[] args) {
        Human obj = new Human();
        System.out.println("Name : " + obj.getName() + " Age : " + obj.getAge());

        obj.setAge(101);
        obj.setName("Mahindra Singh Dhoni");

        System.out.println("Name : " + obj.getName() + " Age : " + obj.getAge());

    }
}
