import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String S, T;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        sb = new StringBuilder(T);

        while(true){

            // S와 T(sb)가 같은지 체크
            if(S.equals(sb.toString())){
                System.out.println(1);
                break;
            }

            // T(sb)의 길이가 1인지 체크 (길이가 1이라는 것은, 더이상 연산이 불가능하다는 의미)
            if(sb.length() == 1){
                System.out.println(0);
                break;
            }

            // T(sb)의 마지막 자리의 문자가 A라면?
            if(sb.charAt(sb.length()-1) == 'A'){
                sb.delete(sb.length()-1, sb.length());
            }else{
                // T(sb)의 마지막 자리의 문자가 B라면?
                sb.delete(sb.length()-1, sb.length());
                sb.reverse();
            }
        }

    }


    private static void init() throws IOException {
        S = br.readLine();
        T = br.readLine();

    }

}