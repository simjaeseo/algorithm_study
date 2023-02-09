import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            l.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(l);

        StringBuilder sb = new StringBuilder();
        for(int n : l){
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }

}