import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[31];

        for (int i = 0; i < 28; i++) {
            array[Integer.parseInt(br.readLine())]++;
        }

        LinkedList<Integer> l = new LinkedList<>();

        for (int i = 1; i <= 30; i++) {
            if(array[i] == 0){
                l.add(i);
            }
        }

        Collections.sort(l);

        for (int number : l) {
            System.out.println(number);
        }
    }
}