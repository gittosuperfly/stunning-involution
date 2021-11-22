package main.leetcode;

public class LC034 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length != 0){
            res[0] = searchLeft(nums,target);
            res[1] = searchRight(nums,target);
        }
        return res;
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
