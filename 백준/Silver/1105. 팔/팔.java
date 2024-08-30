import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int L, R;
    static String Ls, Rs;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());

        Ls = st.nextToken();
        Rs = st.nextToken();

        boolean LFlag = false;
        boolean RFlag = false;

        for (int i = 0; i < Ls.length(); i++) {
            if(Ls.charAt(i) == '8') {
                LFlag = true;
                break;
            }
        }

        for (int i = 0; i < Rs.length(); i++) {
            if(Rs.charAt(i) == '8') {
                RFlag = true;
                break;
            }
        }

        if(!LFlag || !RFlag || Ls.length() != Rs.length()){
            System.out.println(0);
            return;
        }

        if(Ls.equals(Rs)){
            int eightCount = 0;

            for (int i = 0; i < Ls.length(); i++) {
                if(Ls.charAt(i) == Rs.charAt(i) && Ls.charAt(i) == '8') eightCount++;
            }
            System.out.println(eightCount);
            return;
        }

        boolean eightEqual = false;


        int eightCount = 0;
        for (int i = 0; i < Ls.length() - 1; i++) {
            if(!eightEqual && Ls.charAt(i) != Rs.charAt(i)) break;
            else if(Ls.charAt(i) == Rs.charAt(i) && Ls.charAt(i) == '8'){
                eightEqual = true;
                eightCount++;
            }else if(eightEqual && Ls.charAt(i) != Rs.charAt(i)) break;
        }

        System.out.println(eightCount);

    }


    private static void init() throws IOException {


    }

}