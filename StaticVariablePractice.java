class Mobile 
{
    String brand , name;
    int price;
    static String mobile_type;

    public void show()
    {
        System.out.println("Brand : " + brand + " | Name : " + name + " | Price : " + price + " | Type : " + mobile_type);
    }
}

public class StaticVariablePractice {
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

    }
}
