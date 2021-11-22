package main.leetcode;

public class LC033 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //如果前半部分有序

            if (nums[l] <= nums[mid]) {
                //如果target在前半部分
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {  //如果后半部分有序
                //如果target在后半部分
                if (nums[mid] < target && target <= nums[len - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
