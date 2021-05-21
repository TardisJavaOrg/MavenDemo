package sort;


public class SortDemo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 215, 21, 12, 1, 2, 42, 21, 4};
//        bubSort_1(nums);
        bubSort_2(nums);
//        insertSort(nums);
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 冒泡排序
     * 最大的数往后移
     */
    public static void bubSort_1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 如果没有出现交换，说明排序已经正确
     */
    public static void bubSort_2(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            flag = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    /**
     * 插入排序
     * 取一个数 curr，保证比这个数大的都在右边
     * 类似于 curr和他左边的都做比较，如果比他小，就再与左边的左边做比较
     */
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int j = i - 1;
            while (j >= 0 && curr < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = curr;
        }
    }

    /**
     * 快速排序
     * 随机取一个数，保证数的左边都比他小，右边都比他大
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = partition_left(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    /**
     * 快速排序的 分割数组部分，以最右边的数作为 随机数
     */
    private static int partition_right(int[] nums, int left, int right) {
        int p = nums[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[i] < p) i++;
            if (i != j) {
                exchange(nums, i, j);
                j--;
            }

            while (i < j && nums[j] > p) j--;
            if (i != j) {
                exchange(nums, i, j);
                i++;
            }
        }
        return j;
    }

    /**
     * 快速排序的 分割数组部分，以最左边的数作为 随机数
     */
    private static int partition_left(int[] nums, int left, int right) {
        int p = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] > p) j--;
            if (i < j) {
                exchange(nums, i, j);
                i++;
            }
            while (i < j && nums[i] < p) i++;
            if (i < j) {
                exchange(nums, i, j);
                j--;
            }
        }
        return j;
    }


    private static void mergerSort(){
        // TODO: 2021/3/21 待完成
    }

    /**
     * 排序中常用到的交换两个数的方法
     */
    private static void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}