package main.leetcode;

public class LC079 {

    public static void main(String[] args) {
        System.out.println(new LC079().exist(new char[][]{
                        {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
                }, "ABCCED"
        ));
    }

    boolean result = false;

    public boolean exist(char[][] board, String word) {
        boolean[][] hasUsed = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    search(board, i, j, word, 0, hasUsed);
                }
            }
        }
        return result;
    }

    public void search(char[][] board, int i, int j, String word, int index, boolean[][] hasUsed) {
        //index越界了说明已经找全了
        if (index == word.length()) {
            result = true;
            return;
        }
        //越界情况
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        //已经用过了或者不是需要的字符
        if (board[i][j] != word.charAt(index) || hasUsed[i][j]) {
            return;
        }
        hasUsed[i][j] = true;
        search(board, i + 1, j, word, index + 1, hasUsed);
        search(board, i - 1, j, word, index + 1, hasUsed);
        search(board, i, j + 1, word, index + 1, hasUsed);
        search(board, i, j - 1, word, index + 1, hasUsed);
        hasUsed[i][j] = false;
    }
}
