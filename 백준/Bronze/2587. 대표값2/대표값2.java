import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int number = Integer.parseInt(br.readLine());
            l.add(number);
            sum += number;
        }

        Collections.sort(l);
        System.out.println(sum/5);
        System.out.println(l.get(2));
    }
}