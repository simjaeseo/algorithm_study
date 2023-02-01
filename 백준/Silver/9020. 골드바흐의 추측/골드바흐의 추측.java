import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());

            ArrayList<Integer> primes = getPrime(number);
            ArrayList<Partition> partitions = findPartition(primes, number);
            Collections.sort(partitions);
            System.out.println(partitions.get(0).num1 + " " + partitions.get(0).num2);
        }

    }

    private static ArrayList<Partition> findPartition(ArrayList<Integer> primes, int number) {
        Collections.reverse(primes);

        ArrayList<Partition> partitions = new ArrayList<>();

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (primes.get(i) + primes.get(j) == number) {
                    partitions.add(new Partition(primes.get(i),primes.get(j)));
                }
            }
            if (primes.get(i) + primes.get(i) == number) {
                partitions.add(new Partition(primes.get(i),primes.get(i)));
            }
        }

        return partitions;

    }

    private static ArrayList<Integer> getPrime(int number) {
        int[] arr = new int[number + 1];

        for (int i = 2; i <= number; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= number; i++) {
            for (int j = i + i; j <= number; j += i) {
                if (arr[j] == 0) continue;
                arr[j] = 0;
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (arr[i] != 0) {
                primes.add(arr[i]);
            }
        }

        return primes;
    }

    public static class Partition implements Comparable<Partition>{
        int num1;
        int num2;

        Partition(int num1, int num2){
            if(num1 < num2){
                this.num1 = num1;
                this.num2 = num2;
            }else{
                this.num1 = num2;
                this.num2 = num1;

            }

        }

        @Override
        public int compareTo(Partition o) {
            return Math.abs(this.num1 - this.num2) - Math.abs(o.num1 - o.num2) ;
        }

    }


}