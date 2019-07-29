import java.util.*;

public class AggressiveCows {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine()); //Number of test cases
        for (int x = 0; x < T; x++) {
            StringTokenizer line = new StringTokenizer(in.nextLine());
            int S = Integer.parseInt(line.nextToken()); //Number of stalls
            int C = Integer.parseInt(line.nextToken()) - 1; //Number of cows;
            int[] stalls = new int[S];
            for (int i = 0; i < S; i++) {
                stalls[i] = Integer.parseInt(in.nextLine());
            }
            int lastPlaced;
            int placed;
            int current;
            boolean works = false;
            int distance = stalls[stalls.length - 1]/C + 1;
            Arrays.sort(stalls);
            while (!works){
                lastPlaced = stalls[0];
                current = 0;
                placed = 0;
                while (true){
                    try {
                        int stall = stalls[current + 1];
                        if (stall >= lastPlaced + distance) {
                            placed++;
                            lastPlaced = stall;
                        } else {
                            current++;
                        }
                    } catch (ArrayIndexOutOfBoundsException aioobe){
                        if (placed == C) {
                            works = true;
                        }
                        break;
                    }
                }
                distance--;
            }
            System.out.println(distance + 1);
        }
    }
}
