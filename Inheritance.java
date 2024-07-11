public class Inheritance {
    public static void main(String[] args) {
        Calc obj = new Calc();
        int r1 = obj.add(12, 12);
        int r2 = obj.substract(1222, 122);
        System.out.println(r1);
        System.out.println(r2);

        AdvanceCalc obj2 = new AdvanceCalc();
        int r3 = obj2.add(12, 12);
        int r4 = obj2.substract(1222, 122);
        int r5 = obj2.multiply(12, 12);
        int r6 = obj2.divide(1222, 122);
        System.out.println(r5);
        System.out.println(r6);
    }
}
