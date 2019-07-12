import java.util.*;

public class PrintThePossibleWords {
    private static void printCombinations(String[] nums, int currentIndex, String[] combination){
        if (currentIndex == nums.length){
            StringBuilder output = new StringBuilder();
            for (String letter: combination){
                output.append(letter);
                output.append(" ");
            }
            System.out.println(output.toString());
            return;
        }
        switch (nums[currentIndex]){
            case "2":
                for (String letter: new String[] {"A", "B", "C"}){
                    combination[currentIndex] = letter;
                    printCombinations(nums, currentIndex + 1, combination);
                    combination[currentIndex] = null;
                }
                return;
            case "3":
                for (String letter: new String[] {"D", "E", "F"}){
                    combination[currentIndex] = letter;
                    printCombinations(nums, currentIndex + 1, combination);
                    combination[currentIndex] = null;
                }
                return;
            case "4":
                for (String letter: new String[] {"G", "H", "I"}){
                    combination[currentIndex] = letter;
                    printCombinations(nums, currentIndex + 1, combination);
                    combination[currentIndex] = null;
                }
                return;
            case "5":
                for (String letter: new String[] {"J", "K", "L"}){
                    combination[currentIndex] = letter;
                    printCombinations(nums, currentIndex + 1, combination);
                    combination[currentIndex] = null;
                }
                return;
            case "6":
                for (String letter: new String[] {"M", "N", "O"}){
                    combination[currentIndex] = letter;
                    printCombinations(nums, currentIndex + 1, combination);
                    combination[currentIndex] = null;
                }
                return;
            case "7":
                for (String letter: new String[] {"P", "Q", "R", "S"}){
                    combination[currentIndex] = letter;
                    printCombinations(nums, currentIndex + 1, combination);
                    combination[currentIndex] = null;
                }
                return;
            case "8":
                for (String letter: new String[] {"T", "U", "V"}){
                    combination[currentIndex] = letter;
                    printCombinations(nums, currentIndex + 1, combination);
                    combination[currentIndex] = null;
                }
                return;
            case "9":
                for (String letter: new String[] {"W", "X", "Y", "Z"}){
                    combination[currentIndex] = letter;
                    printCombinations(nums, currentIndex + 1, combination);
                    combination[currentIndex] = null;
                }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split(" ");
        String[] combination = new String[nums.length];
        printCombinations(nums, 0, combination);
    }
}
