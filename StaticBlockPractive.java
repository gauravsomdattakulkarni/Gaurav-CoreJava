class Mobile 
{
    String brand , name;
    int price;
    static String mobile_type;

    static 
    {
        mobile_type = "Smart Phone";
    }

    public Mobile()
    {
        name ="";
        brand="";
        price=0;
    }

    public void show()
    {
        System.out.println("Brand : " + brand + " | Name : " + name + " | Price : " + price + " | Type : " + mobile_type);
    }


}


public class StaticBlockPractive {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("Mobile");
        
        Mobile mob1 = new Mobile();
        mob1.brand = "SAMSUNG";
        mob1.name = "F23 5G";
        mob1.price = 25000;
        
        Mobile mob2 = new Mobile();
        mob2.brand = "Apple";
        mob2.name = "A11 5G";
        mob2.price = 2500000;

        Mobile mob3 = new Mobile();

        mob1.show();
        mob2.show();
        mob3.show();
    }
}
