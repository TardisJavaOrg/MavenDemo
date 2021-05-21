import java.util.Scanner;

public class SelfNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 1; // 包含0
        while (scanner.hasNext()) {
            count =0;
            int num = scanner.nextInt();
            for (int i = 1; i <= num; i++) {
            int len = String.valueOf(i).length();
                if ((i * i - i) % (Math.pow(10,len)) == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
