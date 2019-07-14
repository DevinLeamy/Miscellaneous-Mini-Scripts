import java.util.*;

public class Cryptopangrams {
    private static int[] findFactors(int num, ArrayList<Integer> primes){
        int[] factors = new int[2];
        for (int prime: primes){
            if (prime == 1){
                continue;
            }
            if (num % prime == 0){
                factors[0] = prime;
                factors[1] = (num / prime);
                break;
            }
        }
        return factors;
    }
    private static boolean isPrime(int P){
        for (int i = 2; i <= (P/2); i++){
            if (P % i == 0){
                return false;
            }
        }
        return true;
    }
    private static ArrayList<Integer> getPrimes(int N){
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(1);
        primes.add(2);
        for (int i = 3; i <= N; i++){
            if (isPrime(i)){
                primes.add(i);
            }
        }
        return primes;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer values = new StringTokenizer(in.nextLine());
            int N = Integer.parseInt(values.nextToken());
            int L = Integer.parseInt(values.nextToken());
            HashMap<Integer, int[]> posAndFactors = new HashMap<>();
            String[] nums = in.nextLine().split(" ");
            StringBuilder output = new StringBuilder();
            ArrayList<Integer> primes = getPrimes(N);
            Set<Integer> used = new HashSet<>();
            for (int x = 0; x < L; x++){
                int value = Integer.parseInt(nums[x]);
                int[] factors = findFactors(value, primes);
                used.add(factors[0]);
                used.add(factors[1]);
                posAndFactors.put(value, factors);
            }
            ArrayList<Integer> sortedUsed = new ArrayList<>(used);
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Collections.sort(sortedUsed);
            for (int x = 0; x < L; x++){
                int value = Integer.parseInt(nums[x]);
                int[] factors = posAndFactors.get(value);
                try {
                    int valueAfter = Integer.parseInt(nums[x + 1]);
                    int[] nextFactors = posAndFactors.get(valueAfter);
                    for (int num : factors) {
                        if (num != nextFactors[0] && num != nextFactors[1]) {
                            output.append(alphabet.charAt(sortedUsed.indexOf(num)));
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException aioobe){
                    int valueBefore = Integer.parseInt(nums[x - 1]);
                    int[] previousFactors = posAndFactors.get(valueBefore);
                    for (int num : factors) {
                        if (num == previousFactors[0] || num == previousFactors[1]){
                            output.append(alphabet.charAt(sortedUsed.indexOf(num)));
                        } else{
                            output.append(alphabet.charAt(sortedUsed.indexOf(num)));
                        }
                    }
                    break;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + output.toString());
        }
    }
}
