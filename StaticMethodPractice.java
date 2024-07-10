class Mobile 
{
    String brand , name;
    int price;
    static String mobile_type;

    public void show()
    {
        System.out.println("Brand : " + brand + " | Name : " + name + " | Price : " + price + " | Type : " + mobile_type);
    }

    public static void show1()
    {
        //static variable can be used inside static method
        //non static variables can not be used inside the static method
        System.out.println("Simple Static Method");
    }

    public static void show_mobile_info(Mobile mobile)
    {
        System.out.println("Brand : " + mobile.brand + " | Name : " + mobile.name + " | Price : " + mobile.price + " | Type : " + mobile_type);
    }
}


public class StaticMethodPractice {
    public static void main(String[] args) {
        Mobile.mobile_type = "Smart Phone";

        Mobile mob1 = new Mobile();
        mob1.brand = "SAMSUNG";
        mob1.name = "F23 5G";
        mob1.price = 25000;
        
        Mobile mob2 = new Mobile();
        mob2.brand = "Apple";
        mob2.name = "A11 5G";
        mob2.price = 2500000;

        mob1.show();
        mob2.show();

        Mobile.show1();

        Mobile.show_mobile_info(mob1);
    }
}
