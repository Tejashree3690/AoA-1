public class NQueens {
    static final int N = 4;
    static boolean isSafe(char[][] board, int row, int col) {
       
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        } 
        return true;
    }

    static void printSolution(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void solveNQueens(char[][] board, int row) {
        if (row == N) {
            printSolution(board);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q'; 
                solveNQueens(board, row + 1);
                board[row][i] = '-';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '-';
            }
        }
        solveNQueens(board, 0);
    }
}