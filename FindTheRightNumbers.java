import java.util.*;

public class FindTheRightNumbers {
    private static int counter = 0;
    private static String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static void findNumbers(int length, int currentLength, int sum, int currentSum, StringBuilder num){
        if (length == currentLength){
            if (sum == currentSum){
                System.out.println(num.toString());
                counter++;
            }
            return;
        }
        for (String digit: nums){
            if (currentSum + Integer.parseInt(digit) <= sum){
                String hold = num.toString();
                num.append(digit);
                findNumbers(length, currentLength + 1, sum, currentSum + Integer.parseInt(digit), num);
                num = new StringBuilder(hold);
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int S = Integer.parseInt(in.nextLine());
        if (S < N){
            System.out.println("INVALID INPUT");
        } else {
            findNumbers(N, 0, S, 0, new StringBuilder());
            System.out.println("Total: " + counter);
        }
    }
}
