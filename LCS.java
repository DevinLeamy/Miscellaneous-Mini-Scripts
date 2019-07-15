import java.util.*;

public class LCS {
    private static void fillTable(String string1, String string2, int[][] T){
        for (int i = 1; i < string1.length() + 1; i++){
            for (int x = 1; x < string2.length() + 1; x++){
                if (string1.charAt(i -1) == string2.charAt(x - 1)){
                    T[i][x] = T[i - 1][x - 1] + 1;
                } else {
                    T[i][x] = Integer.max(T[i - 1][x], T[i][x - 1]);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String string1 = in.nextLine();
        String string2 = in.nextLine();
        int[][] T = new int[string1.length() + 1][string2.length() + 1];
        fillTable(string1, string2, T);
        System.out.println(T[string1.length()][string2.length()]);
    }
}
