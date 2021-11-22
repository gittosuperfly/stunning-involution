package main.leetcode;

public class LC011 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left <= right) {
            int s = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(s, max);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
