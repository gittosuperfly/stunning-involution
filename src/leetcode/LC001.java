package leetcode;

import java.util.HashMap;

public class LC001 {
    public int[] twoSum(int[] nums, int target) {
        //HashMap用来存储Key为预期值，Value为对应的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //获取预期值
            int expect = target - nums[i];
            //在HashMap中查找预期值
            if (map.containsKey(expect)) {
                //找到就返回预期值下标与当前值下标
                return new int[]{map.get(expect), i};
            }
            //未找到的话存入预期值与index
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}