package main.time.data.part8_stack;

import main.leetcode.help.Linked;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solutions {

    public static void main(String[] args) {

    }

    static ArrayList<Character> nums;

    static {
        nums = new ArrayList<>();
        nums.add('0');
        nums.add('1');
        nums.add('2');
        nums.add('3');
        nums.add('4');
        nums.add('5');
        nums.add('6');
        nums.add('7');
        nums.add('8');
        nums.add('9');
        nums.add('.');
    }


    private static double getVal(String express) {
        LinkedList<Double> numsStack = new LinkedList<>();
        LinkedList<Character> charStack = new LinkedList<>();

        StringBuilder temp = new StringBuilder();
        int lastType = 1;
        int type = 0;

        for (int i = 0; i < express.length(); i++) {
            char ch = express.charAt(i);
            type = getType(ch);
            if (type == 0) {
                System.out.println("error");
                return -1;
            }
            if (type == 1) {
                if (lastType == 2){
                    temp = new StringBuilder();
                    lastType = 1;
                }
                temp.append(ch);
            }
            if (type == 2){
                numsStack.addFirst(Double.parseDouble(temp.toString()));
                lastType = 2;

            }
        }


        return 0;
    }

    private static int getType(char ch) {
        if (nums.contains(ch)) {
            return 1;
        }
        if (ch == '+' || ch == '-') {
            return 2;
        }
        if (ch == '*' || ch == '/') {
            return 3;
        }
        return 0;
    }


}
