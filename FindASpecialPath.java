import java.util.*;

public class FindASpecialPath {
    public static boolean found = false;
    private static ArrayList<String> getMoves(int[][] matrix, int currentX, int currentY){
        ArrayList<String> moves = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++){
            rows.add(i);
        }
        for (int i = 0; i < matrix[0].length; i++){
            cols.add(i);
        }
        int move = matrix[currentX][currentY];
        if (rows.contains(currentX + move)){
            moves.add((currentX + move) + " " + currentY);
        }
        if (rows.contains(currentX - move)){
            moves.add((currentX - move) + " " + currentY);
        }
        if (cols.contains(currentY + move)){
            moves.add(currentX + " " + (currentY + move));
        }
        if (cols.contains(currentY - move)){
            moves.add(currentX + " " + (currentY - move));
        }
        return moves;
    }
    private static void findAPath(int[][] matrix, int endX, int endY, int currentX, int currentY, ArrayList<String> moves, int mark){
        if (found){
            return;
        }
        if (endX == currentX && endY == currentY){
            System.out.println(moves);
            found = true;
            return;
        }
        int hold = matrix[currentX][currentY];
        ArrayList<String> nextMoves = getMoves(matrix, currentX, currentY);
        matrix[currentX][currentY] = mark;
        for (String move: nextMoves){
            int x = Integer.parseInt(move.split(" ")[0]);
            int y = Integer.parseInt(move.split(" ")[1]);
            if (matrix[x][y] != mark){
                moves.add(move);
                findAPath(matrix, endX, endY, x, y, moves, mark);
                moves.remove(move);
            }
        }
        matrix[currentX][currentY] = hold;
    }
    public static void main(String[] args){
        int[][] matrix = {
                { 7, 1, 3, 5, 3, 6, 1, 1, 7, 5 },
                { 2, 3, 6, 1, 1, 6, 6, 6, 1, 2 },
                { 6, 1, 7, 2, 1, 4, 7, 6, 6, 2 },
                { 6, 6, 7, 1, 3, 3, 5, 1, 3, 4 },
                { 5, 5, 6, 1, 5, 4, 6, 1, 7, 4 },
                { 3, 5, 5, 2, 7, 5, 3, 4, 3, 6 },
                { 4, 1, 4, 3, 6, 4, 5, 3, 2, 6 },
                { 4, 4, 1, 7, 4, 3, 3, 1, 4, 2 },
                { 4, 4, 5, 1, 5, 2, 3, 5, 3, 5 },
                { 3, 6, 3, 5, 2, 2, 6, 4, 2, 1 }
        };
        ArrayList<String> moves = new ArrayList<>();
        findAPath(matrix, 9, 9, 0, 0, moves, 0);
    }
}
