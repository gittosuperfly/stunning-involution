package main.leetcode;

import java.util.Stack;

/**
 * 单调栈法
 * 参考：[知乎-单调栈及其应用](https://zhuanlan.zhihu.com/p/101785785)
 */
public class LC084 {

    public static void main(String[] args) {
        LC084 lc = new LC084();
        System.out.println(lc.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    /**
     * 直接在原有数组上判断。最左侧index为-1。当for循环走完后，再依次计算栈内元素的最大面积
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return 1;
        }

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && (heights[i] <= heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int s = (i - leftIndex - 1) * height;
                max = Math.max(max, s);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            int s = (heights.length - leftIndex - 1) * height;
            max = Math.max(max, s);
        }
        return max;
    }

    /**
     * 增加前后哨兵的做法
     *
     * 在高度数组前后两侧各增加一个高度值为0的节点。这样相当于在最后进行了上一种做法中把栈中元素依次出栈的计算。简化了代码
     * 运行时间略长于做法1，不过时间复杂度不变，为 O(n)
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        int max = 0;
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                int leftIndex = stack.peek();
                int s = (i - leftIndex - 1) * height;
                max = Math.max(max, s);
            }
            stack.push(i);
        }
        return max;
    }
}
