package main.leetcode;

import java.util.Random;

public class LC348 {

    /**
     * 洗牌算法
     * <p>
     * for循环遍历，每一个都和余下的数字随机进行交换
     */

    class Solution {
        int[] nums;
        Random random = new Random();


        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] ans = nums.clone();
            for (int i = 0; i < ans.length; i++) {
                swap(ans, i, i + random.nextInt(ans.length - i));
            }
            return ans;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
