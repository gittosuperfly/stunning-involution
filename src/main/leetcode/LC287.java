package main.leetcode;

/**
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * <p>
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class LC287 {
    public static void main(String[] args) {
        System.out.println(new LC287().findDuplicate(new int[]{
                1, 2, 3, 4, 5, 6, 7, 6
        }));
    }

    /**
     * 二分法解决
     */
    public int findDuplicate(int[] nums) {
        //从 1 到 n
        int l = 1;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            //这部分是记录小于mid的数的个数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            //如果count > mid，则说明小于mid的数字多了，有重复的，所以缩小重复范围到 (l , mid)
            if (count > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
