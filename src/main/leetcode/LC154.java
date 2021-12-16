package main.leetcode;

/**
 * 153 旋转数组 加强版，数字可能重复
 */
public class LC154 {
    public static void main(String[] args) {
        System.out.println(new LC154().findMin(new int[]{3,3,3,3,3,3,1,3,3}));
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r -= 1;
            }
        }
        return nums[l];
    }
}
