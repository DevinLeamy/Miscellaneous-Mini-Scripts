import java.util.*;

public class YouCanGoYourOwnWay {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(in.nextLine());
            String path = in.nextLine();
            StringBuilder output = new StringBuilder();
            for (int x = 0; x < path.length(); x++){
                String character = String.valueOf(path.charAt(x));
                switch (character){
                    case "E":
                        output.append("S");
                        break;
                    case "S":
                        output.append("E");
                        break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
    }
}
