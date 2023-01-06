import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> permutation = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            permutation.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        for (int startIndex = 0; startIndex < N; startIndex++) {
            int sum = 0;
            for (int searchIndex = startIndex; searchIndex < N; searchIndex++) {
                sum += permutation.get(searchIndex);

                if(sum > M) break;

                if(sum == M) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);

    }
}