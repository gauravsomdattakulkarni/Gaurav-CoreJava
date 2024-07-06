 class TypeConversion 
 {
    public static void main(String[] args) {
        byte b = 125;
        int a = 12;
        boolean test=false;

        b = (byte) a;

        int a1, b1;

a1=b1=10;

int a3 = 3;

int b3 = 6;

int result = (~a3 & b3) | (a3 & ~b3);


int x = 5;

int y = 10;

int z = (x++ > 5 && y-- < 10) ? x-- : y;


int i, j;

i = 100;

j = 300;

while(++i < --j);

System.out.println(i);

System.out.println(x + " --> " +z);



System.out.println(result);


System.out.println(a1);

System.out.println(b1);

        System.out.println(test);
        System.out.println(!(true||false));
    }
}
