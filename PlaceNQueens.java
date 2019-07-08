import java.util.*;

public class PlaceNQueens {
    private static boolean isSafe(String[][] board, int row, int col){
        for (int i = 0; i < board.length; i++){
            if (board[row][i].equals("Q")){
                return false;
            }
            if (board[i][col].equals("Q")){
                return false;
            }
        }
        int hold = col;
        for (int i = row; i < board.length; i++){
            if (board[i][col].equals("Q")){
                return false;
            }
            col++;
            if (col< board.length && col >= 0){
            } else {
                break;
            }
        }
        col = hold;
        for (int i = row; i >= 0; i--){
            if (board[i][col].equals("Q")){
                return false;
            }
            col--;
            if (col < board.length && col >= 0){
            } else {
                break;
            }
        }
        col = hold;
        hold = row;
        for (int i = col; i < board.length; i++){
            if (board[row][i].equals("Q")){
                return false;
            }
            row--;
            if (row < board.length && row >= 0){
            } else {
                break;
            }
        }
        row = hold;
        for (int i = col; i >= 0; i--){
            if (board[row][i].equals("Q")){
                return false;
            }
            row++;
            if (row < board.length && row >= 0){
            } else {
                break;
            }
        }
        return true;
    }
    private static void placeQueens(String[][] board, int row){
        if (row == board.length){
            for (String[] line: board){
                System.out.println(Arrays.toString(line));
            }
            System.out.println("******************");
            return;
        }
        for (int col = 0; col < board.length; col++){
            if (isSafe(board, row, col)){
                board[row][col] = "Q";
                placeQueens(board, row+1);
                board[row][col] = "_";
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String[][] board = new String[N][N];
        for (String[] row: board){
            Arrays.fill(row, "_");
        }
        placeQueens(board, 0);
    }
}
