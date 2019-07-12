import java.util.*;

public class WhatAreThePossibleStrings {
    private static void countPossibleStrings(String[] string, int currentIndex){
        if (currentIndex == string.length){
            System.out.println(Arrays.toString(string));
            return;
        }
        if (string[currentIndex].equals("?")){
            for (int i = 0; i < 2; i++){
                string[currentIndex] = String.valueOf(i);
                countPossibleStrings(string, currentIndex + 1);
                string[currentIndex] = "?";
            }
            return;
        }
        countPossibleStrings(string, currentIndex + 1);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] set = in.nextLine().split("");
        countPossibleStrings(set, 0);
    }
}
