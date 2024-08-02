import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

class Main {
    static int n,m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        BigInteger nF = new BigInteger("1");
        for (int i = n; i > n-m; i--) {
            nF = nF.multiply(new BigInteger(String.valueOf(i)));
        }

        BigInteger mF = new BigInteger("1");
        for (int i = 1; i <= m; i++) {
            mF = mF.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(nF.divide(mF));
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

    }

}