package main.leetcode;

public class LC130 {

    public static void main(String[] args) {
        char[][] ch = new char[][]{
                {'O', 'O'}, {'O', 'O'}
        };
        new LC130().solve(ch);
    }

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            search(board, 0, i);
            search(board, board[0].length - 1, i);
        }
        for (int i = 0; i < board[0].length; i++) {
            search(board, i, 0);
            search(board, i, board.length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void search(char[][] board, int x, int y) {
        if (board[y][x] == 'O') {
            board[y][x] = '#';
            if (x > 0) {
                search(board, x - 1, y);
            }
            if (x < board[0].length - 1) {
                search(board, x + 1, y);
            }
            if (y > 0) {
                search(board, x, y - 1);
            }
            if (y < board.length - 1) {
                search(board, x, y + 1);
            }
        }
    }
}
