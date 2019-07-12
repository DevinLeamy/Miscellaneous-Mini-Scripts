import java.util.*;

public class FindAllParentheses {
    public static int counter = 0;
    private static void findCombinations(int length, StringBuilder current, int open){
        if (length == current.length()){
            if (open == 0) {
                System.out.println(current.toString());
                counter++;
            }
            return;
        }
        if (open == 0){
            current.append("(");
            findCombinations(length, current, open + 1);

        } else {
            for (String parentheses: new String[] {"(", ")"}){
                String hold = current.toString();
                switch (parentheses){
                    case ")":
                        current.append(parentheses);
                        findCombinations(length, current, open - 1);
                        break;
                    case "(":
                        current.append(parentheses);
                        findCombinations(length, current, open + 1);
                }
                current = new StringBuilder(hold);
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        findCombinations(n, new StringBuilder(), 0);
        System.out.println(counter);
    }
}
