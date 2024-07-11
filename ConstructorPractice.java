class Human
{
    private int age;
    private String name;

    public Human()
    {
        age = 12;
        name ="Karan";

        System.out.println("In Constructor");
        
    }

    public Human(int age , String name)
    {
        this.age = age;
        this.name = name;

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

public class ConstructorPractice {
    public static void main(String[] args) {
        Human obj1 = new Human();
        System.out.println("Name : " + obj1.getName() + " Age : " + obj1.getAge());


        Human obj = new Human(90,"Rohit Karma");
        System.out.println("Name : " + obj.getName() + " Age : " + obj.getAge());

        obj.setAge(101);
        obj.setName("Mahindra Singh Dhoni");

        System.out.println("Name : " + obj.getName() + " Age : " + obj.getAge());

    }
}
