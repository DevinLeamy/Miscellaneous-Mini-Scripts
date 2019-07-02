import java.util.*;

public class AddBigStrings {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String numOne = in.nextLine();
        String numTwo = in.nextLine();
        int currentOne = numOne.length() - 1;
        int currentTwo = numTwo.length() - 1;

        String output = "";
        int added;
        int remainder = 0;
        int currentL = (numOne.length() >= numTwo.length())? numOne.length() - 1: numTwo.length() - 1;
        String largest = (numOne.length() >= numTwo.length())? numOne: numTwo;

        while (currentL >= 0){
            try {
                added = Integer.parseInt(String.valueOf(numOne.charAt(currentOne))) + Integer.parseInt(String.valueOf(numTwo.charAt(currentTwo))) + remainder;
                remainder = 0;
                if (added >= 10){
                    added -= 10;
                    remainder++;
                }
                output = added + output;
            } catch (StringIndexOutOfBoundsException sioobe){
                if (remainder == 1){
                    added = Integer.parseInt(String.valueOf(largest.charAt(currentL))) + remainder;
                    remainder = 0;
                    if (added >= 10){
                        added -= 10;
                        remainder++;
                    }
                    output = added + output;
                }
                else {
                    output = largest.charAt(currentL) + output;
                }
            }
            if (currentL == 0 && remainder == 1){
                added = (Integer.parseInt(String.valueOf(largest.charAt(currentL))) + remainder)/10;
                remainder = 0;
                output = added + output;
            }
            currentOne--;
            currentTwo--;
            currentL--;
        }
        System.out.println(output);
    }
}
