import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String A,B;
    static int dp[][], max;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        createDPTable();
        searchLCSString();

        System.out.println(dp[A.length()][B.length()]);
        System.out.println(sb.reverse());
    }

    private static void searchLCSString() {

        int i = A.length();
        int j = B.length();

        while(true){
            if(dp[i][j] == 0)   break;
            if(dp[i][j] == dp[i-1][j]){
                i--;
            }else if(dp[i][j] == dp[i][j-1]){
                j--;
            }else{
                i--;
                j--;
                sb.append(A.charAt(i));
            }
        }

    }

    private static void createDPTable() {

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

//        for (int i = 0; i <= A.length(); i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }

    private static void init() throws IOException {
        A = br.readLine();
        B = br.readLine();

        dp = new int[A.length()+1][B.length()+1];
    }
}