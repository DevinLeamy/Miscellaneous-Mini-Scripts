import java.util.*;

public class KnightTours {
    private static final int N = 5;
    private static int count = 0;
    private static ArrayList<String> getMoves(int row, int col){
        ArrayList<String> moves = new ArrayList<>();
        int[][] possibleMoves = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        for (int[] shift: possibleMoves){
            int newRow = row + shift[0];
            int newCol = col + shift[1];
            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N){
                moves.add(newRow + " " + newCol);
            }
        }
        return moves;
    }
    private static void getTours(int[][] board, int currentRow, int currentCol, int moveNum){

        if (moveNum > N*N){
            for (int[] row: board){
                System.out.println(Arrays.toString(row));
            }
            System.out.println("---------");
            count++;
            board[currentRow][currentCol] = 0;
            return;
        }
        ArrayList<String> moves = getMoves(currentRow, currentCol);
        if (moves.size() > 0) {
            for (String move : getMoves(currentRow, currentCol)) {
                int newRow = Integer.parseInt(move.split(" ")[0]);
                int newCol = Integer.parseInt(move.split(" ")[1]);
                if (board[newRow][newCol] == 0) {
                    board[newRow][newCol] = moveNum;
                    getTours(board, newRow, newCol, moveNum + 1);
                }
            }
        }
        board[currentRow][currentCol] = 0;
    }
    public static void main(String[] args){
        boolean[][] board = new boolean[N][N];
        board[0][0] = true;
        for (boolean[] row: board){
            Arrays.fill(row, false);
        }
        int[][] tracker = new int[N][N];
        tracker[0][0] = 1;
        getTours(tracker, 0, 0, 2);
        System.out.println(count);
    }
}
