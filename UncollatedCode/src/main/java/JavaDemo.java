import java.util.ArrayList;

public class JavaDemo {
    public static void main(String[] args) {
        test();
    }

    public static int test() {
        int i = 0;
        try {
            return 1 / (++i);
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            System.out.println("finally" + "  " + i);
        }
        return 99;
    }
}