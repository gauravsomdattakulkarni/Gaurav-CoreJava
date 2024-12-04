import JavaCustom.tools.AdvanceCalc;
import JavaCustom.tools.Calc;

public class DemoNew {
    public static void main(String[] args) {
        Calc obj = new Calc();
        System.out.println(obj.add(12,12));

        AdvanceCalc obj2 = new AdvanceCalc();
        System.out.println(obj2.divide(1200, 90));
    }
}
