import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game24 {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        int n4 = scanner.nextInt();
        ArrayList<Double> nums = new ArrayList();
        nums.add((double) n1);
        nums.add((double) n2);
        nums.add((double) n3);
        nums.add((double) n4);
        ArrayList<Character> arr = new ArrayList();
        arr.add('+');
        arr.add('-');
        arr.add('*');
        arr.add('/');

        System.out.println(resolve(nums));
    }

    public static boolean resolve(List<Double> list) {
        for (int i = 0; i < list.size(); i++) { // 取一个数字
            for (int j = 0; j < list.size(); j++) { // 取第二个数字
                if (i == j) continue;
                ArrayList<Double> list2 = new ArrayList<>(); // 存储计算后的数字

                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) list2.add(list.get(k)); // 把另外的数字先保存
                }

                for (int k = 0; k < 4; k++) { // 不同方式计算2个数字
                    if (k < 2 && i > j) continue; // k < 2 表示 +和* ,这两个运算有交换律，i > j 说明已经算过了
                    if (k == ADD) list2.add(list.get(i) + list.get(j));
                    else if (k == MULTIPLY) list2.add(list.get(i) * list.get(j));
                    else if (k == SUBTRACT) list2.add(list.get(i) - list.get(j));
                    else if (k == DIVIDE) {
                        if (Math.abs(list.get(j)) < EPSILON) continue; // 如果绝对值小于1e-6 说明除数为0，可以忽略
                        else list.add(list.get(i) / list.get(j)); // 否则就计算
                    }
                    if (resolve(list2)) return true; // 用3个数字递归运算
                    list2.remove(list2.size() - 1); // 到这一步，说明上面一步递归的都是错的，移除最后一个数字。重新来
                }

            }
        }
        return false;
    }
}
