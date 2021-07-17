import java.text.SimpleDateFormat;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-07-01 16:51
 */
public class MainTest {
    public static void main(String[] args) {
        long timestamp = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(0);
        System.out.println(time);
    }
}
