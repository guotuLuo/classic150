import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        char[][] board = new char[][]{
//                {'5','3','.','.','7','.','.','.','.'}
//                ,{'6','.','.','1','9','5','.','.','.'}
//                ,{'.','9','8','.','.','.','.','6','.'}
//                ,{'8','.','.','.','6','.','.','.','3'}
//                ,{'4','.','.','8','.','3','.','.','1'}
//                ,{'7','.','.','.','2','.','.','.','6'}
//                ,{'.','6','.','.','.','.','2','8','.'}
//                ,{'.','.','.','4','1','9','.','.','5'}
//                ,{'.','.','.','.','8','.','.','7','9'}
                 {'.','.','.','.','5','.','.','1','.'},
                 {'.','4','.','3','.','.','.','.','.'},
                 {'.','.','.','.','.','3','.','.','1'},
                 {'8','.','.','.','.','.','.','2','.'},
                 {'.','.','2','.','7','.','.','.','.'},
                 {'.','1','5','.','.','.','.','.','.'},
                 {'.','.','.','.','.','2','.','.','.'},
                 {'.','2','.','9','.','.','.','.','.'},
                 {'.','.','4','.','.','.','.','.','.'}
        };
        boolean flag = isValidSudoku(board);
        System.out.println(flag);
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            List<Character> rowList = new ArrayList<>();
            List<Character> colList = new ArrayList<>();
            List<Character> gridList = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if(rowList.contains(board[i][j])){
                    return false;
                }else {
                    if(board[i][j] != '.'){
                        rowList.add(board[i][j]);
                    }
                }
            }
            for (int j = 0; j < 9; j++) {
                if(colList.contains(board[j][i])){
                    return false;
                }else {
                    if(board[j][i] != '.'){
                        colList.add(board[j][i]);
                    }
                }
            }
            // i 代表的是第几个方块
            // j 代表的是第几个位置
            // (i / 3) * 3代表初始块所在行
            // (i / 3) * 3代表初始块所在列
            // j

            for (int j = 0; j < 9; j++) {
                if(gridList.contains(board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3])){
                    return false;
                }else {
                    if(board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3] != '.'){
                        gridList.add(board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]);
                    }
                }
            }
        }
        return true;
    }
    
}