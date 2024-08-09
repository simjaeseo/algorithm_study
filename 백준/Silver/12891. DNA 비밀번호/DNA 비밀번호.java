import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int S, P, A,C,G,T,answer,a,c,g,t;
    static char[] DNAs;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        // 첫 P만큼의 dna 체크
        for (int i = 0; i < P; i++) {
            addCount(DNAs[i]);
        }

        //최소 조건 만족하는지 체크
        isValid();

        for (int i = P; i < DNAs.length; i++) {
            int headIndex = i - P;

            addCount(DNAs[i]);
            removeCount(DNAs[headIndex]);

            isValid();
        }

        System.out.println(answer);

    }

    private static void removeCount(char dna) {
        if(dna == 'A'){
            a--;
        }else if(dna == 'C'){
            c--;
        }else if(dna == 'G'){
            g--;
        }else if(dna == 'T'){
            t--;
        }
    }

    private static void isValid() {
        if(a >= A && c >= C && g >= G && t >= T) answer++;
    }

    private static void addCount(char dna) {
        if(dna == 'A'){
            a++;
        }else if(dna == 'C'){
            c++;
        }else if(dna == 'G'){
            g++;
        }else if(dna == 'T'){
            t++;
        }
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        DNAs = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
    }

}