import java.util.*;

public class LongestMatrixPath {
    private static int max = 0;
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
    private static void findLongestPath(int[][] matrix, int currentRow, int currentCol, int[] end, int pathLength, boolean[][] visited){
        if (Arrays.equals(end, new int[] {currentRow, currentCol})){
            if (pathLength > max){
                max = pathLength;
                return;
            }
        }
        visited[currentRow][currentCol] = true;
        ArrayList<String> moves = getMoves(matrix, currentRow, currentCol);
        if (moves.size() > 0){
            for (String move: moves){
                int newRow = Integer.parseInt(move.split(" ")[0]);
                int newCol = Integer.parseInt(move.split(" ")[1]);
                if (!visited[newRow][newCol]) {
                    findLongestPath(matrix, newRow, newCol, end, pathLength + 1, visited);
                }
            }
        }
        visited[currentRow][currentCol] = false;
    }
    public static void main(String[] args){
        int[][] matrix = {{1, 0, 0, 1, 0, 1, 1, 0, 0},
                          {1, 1, 1, 1, 0, 0, 1, 1, 1},
                          {1, 0, 0, 1, 1, 1, 1, 0, 1},
                          {0, 0, 0, 1, 0, 0, 0, 0, 1},
                          {1, 0, 1, 1, 1, 0, 1, 1, 1},
                          {1, 0, 1, 0, 1, 0, 1, 0, 0},
                          {1, 0, 1, 0, 1, 1, 1, 1, 0},
                          {1, 1, 1, 0, 1, 0, 0, 1, 1},
                          {1, 0, 0, 0, 1, 1, 1, 1, 1},
                        };
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (boolean[] row: visited){
            Arrays.fill(row, false);
        }
        int[] source = {4, 0};
        int[] end = {8, 5};
        findLongestPath(matrix, source[0], source[1], end, 0, visited);
        System.out.println(max);

    }
}
