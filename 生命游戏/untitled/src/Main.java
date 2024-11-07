public class Main {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == 1){
                    int countLife = 0;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1 ; l++) {
                            if(k >= 0 && k < board.length && l >= 0 && l < board[0].length){
                                if(board[k][l] == 1){
                                    countLife++;
                                }
                            }
                        }
                    }
                    countLife--;
                    if(countLife < 2){
                        res[i][j] = 0;
                    }else if(countLife == 2 || countLife == 3){
                        res[i][j] = 1;
                    }else {
                        res[i][j] = 0;
                    }
                }else{
                    int countLife = 0;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1 ; l++) {
                            if(k >= 0 && k < board.length && l >= 0 && l < board[0].length){
                                if(board[k][l] == 1){
                                    countLife++;
                                }
                            }
                        }
                    }
                    if(countLife == 3){
                        res[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = res[i][j];
            }
        }
    }
}
