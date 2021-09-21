package com.huixiong;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-09-18 11:47
 */
public class ContinueSameNumTest {
    @Test
    public void test() {
        assert get_continue_same_num_test(new int[]{1}) == 1;
        assert get_continue_same_num_test(new int[]{1, 1, 1}) == 3;
        assert get_continue_same_num_test(new int[]{1, 1, 0, 1, 1}) == 2;
        assert get_continue_same_num_test(new int[]{1, 0, 1, 1, 0, 0}) == 2;
        assert get_continue_same_num_test(new int[]{1, 0, 1, 1, 0, 1, 1, 1, 1}) == 4;
        assert get_continue_same_num_test(new int[]{1, 0, 0, 0, 0}) == 1;
        assert get_continue_same_num_test(new int[]{0, 0, 0, 0, 0}) == 0;
        assert get_continue_same_num_test(new int[]{}) == 0;
    }

    public int get_continue_same_num_test(int[] list) {
        int left = 0;
        int right = 0;
        int res = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 1) {
                left = i;
                right = i;
                while (i < list.length && list[i] == 1) {
                    i++;
                    right++;
                }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
