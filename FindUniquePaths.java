import java.util.*;

public class FindUniquePaths {
    private static int counter = 0;
    private static ArrayList<String> getMoves(int[][] matrix, int currentRow, int currentCol){
        ArrayList<String> moves = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            rows.add(i);
        }
        ArrayList<Integer> cols = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++){
            cols.add(i);
        }

        if (rows.contains(currentRow + 1)){
            if (matrix[currentRow + 1][currentCol] == 1) {
                moves.add((currentRow + 1) + " " + currentCol);
            }
        }
        if (rows.contains(currentRow - 1)){
            if (matrix[currentRow - 1][currentCol] == 1) {
                moves.add((currentRow - 1) + " " + currentCol);
            }
        }
        if (cols.contains(currentCol + 1)){
            if (matrix[currentRow][currentCol + 1] == 1) {
                moves.add(currentRow + " " + (currentCol + 1));
            }
        }
        if (cols.contains(currentCol - 1)){
            if (matrix[currentRow][currentCol - 1] == 1) {
                moves.add(currentRow + " " + (currentCol - 1));
            }
        }
        return moves;
    }
    private static void countUniquePaths(int[][] matrix, int currentX, int currentY, int[] end, int mark) {
        if (currentX == end[0] && currentY == end[1]){
            counter++;
            return;
        }
        int hold = matrix[currentX][currentY];
        matrix[currentX][currentY] = mark;
        ArrayList<String> moves = getMoves(matrix, currentX, currentY);
        for (String move: moves){
            int x = Integer.parseInt(move.split(" ")[0]);
            int y = Integer.parseInt(move.split(" ")[1]);
            if (matrix[x][y] != mark){
                countUniquePaths(matrix, x, y, end, mark);
            }
        }
        matrix[currentX][currentY] = hold;

    }
    public static void main(String[] args){
        int[][] matrix = {
                { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 1 },
                { 1, 1, 1, 1 }
        };
        int[] start = {1, 0};
        int[] end = {3, 3};
        countUniquePaths(matrix, start[0], start[1], end, -1);
        System.out.println(counter);
    }
}
