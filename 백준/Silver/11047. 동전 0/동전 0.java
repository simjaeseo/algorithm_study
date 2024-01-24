import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static LinkedList<Integer> l = new LinkedList<>();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {
        init();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            l.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(l,Collections.reverseOrder());

        int count = 0;

        for(int coin : l){
            if(k / coin >= 1){
                count += k / coin;
                k = k % coin;
            }
        }

        System.out.println(count);

    }


}