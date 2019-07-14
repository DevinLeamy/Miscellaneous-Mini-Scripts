import java.util.*;

public class WriteCheques{
    private static int pow(int power){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        for (int i = 0; i < power; i++){
            stringBuilder.append(0);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
    private static ArrayList<Integer> findIndexes(String N){
        ArrayList<Integer> indexes = new ArrayList<>();
        StringBuilder reverseMe = new StringBuilder(N);
        reverseMe.reverse();
        N = reverseMe.toString();
        for (int i = 0; i < N.length(); i++){
            if (String.valueOf(N.charAt(i)).equals("4")){
                indexes.add(i);
            }
        }
        return indexes;
    }
    private static int[] findNums(String T){
        int[] solution = new int[2];
        solution[0] = Integer.parseInt(T);
        ArrayList<Integer> fours = findIndexes(T);
        for (int index: fours){
            if (index == 0){
                solution[0] = solution[0] - 1;
                solution[1] = solution[1] + 1;
            } else {
                int transfer = pow(index);
                solution[0] -= transfer;
                solution[1] += transfer;
            }
        }
        return solution;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for (int i = 0; i < T; i++){
            String N = in.nextLine();
            int[] AandB = findNums(N);
            StringBuilder print = new StringBuilder();
            print.append("Case #");
            print.append((i + 1));
            print.append(": ");
            print.append(AandB[0]);
            print.append(" ");
            print.append(AandB[1]);
            System.out.println(print.toString());
        }
    }
}
