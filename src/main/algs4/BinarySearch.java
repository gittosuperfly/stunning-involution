package main.algs4;


public class BinarySearch {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(search(nums1, 3));

        int[] nums2 = new int[]{1, 2, 3, 4, 4, 4, 4};
        System.out.println(searchLeft(nums2, 4));
        System.out.println(searchRight(nums2, 4));

    }


    /**
     * 查找一个元素
     * <p>
     * 搜索一个元素时,搜索区间两端闭
     * while条件带等号,否则需要打补丁
     * if相等就返回,其他的事爾操心
     * mid必须加减一,因为区间两端闭
     * while结束就凉了,凄凄惨惨返-1
     */
    public static int search(int[] nums, int key) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == key) {
                return mid;
            }
            if (nums[mid] < key) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找左边界
     */
    public static int searchLeft(int[] nums, int key) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= key) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        //记得检查
        if (nums[l] != key) {
            return -1;
        }
        return l;
    }

    /**
     * 查找右边界
     */
    public static int searchRight(int[] nums, int key) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= key) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        //记得检查
        if (nums[r] != key) {
            return -1;
        }
        return r;
    }

}