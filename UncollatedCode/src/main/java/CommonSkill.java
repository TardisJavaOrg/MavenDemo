import org.junit.jupiter.api.Test;

/**
 * Java算法常用技巧
 */
public class CommonSkill {

    /**
     * 各种类型转String
     */
    @Test
    public void charToString(){
        char[] chars = new char[]{'a', 'b', 'c'};
        String res = String.valueOf(chars);
        System.out.println(res);

        int a = 1;
        res = String.valueOf(1);
        System.out.println(res);

    }
    /**
     * 数字数组转String
     */
    @Test
    public void intString(){
    }
}
