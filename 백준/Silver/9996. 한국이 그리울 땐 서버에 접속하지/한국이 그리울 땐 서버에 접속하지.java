import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, lengthAfterStar;
    static char[] patterns;
    static String pattern;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        pattern = br.readLine();
        patterns = pattern.toCharArray();
        lengthAfterStar = pattern.split("\\*")[1].length();

        for (int i = 0; i < N; i++) {
            char[] inputs = br.readLine().toCharArray();

            if(checkInputs(inputs)) sb.append("DA").append('\n');
            else sb.append("NE").append('\n');
        }

        System.out.print(sb);
    }

    private static boolean checkInputs(char[] inputs) {
        if(inputs.length < patterns.length) {
            patterns = new char[pattern.length()-1];

            int index = 0;
            for (int i = 0; i < pattern.length(); i++) {
                if(pattern.charAt(i) != '*') patterns[index++] = pattern.charAt(i);
            }
        }
        else patterns = pattern.toCharArray();

        int patternsIndex = 0;

        for (int j = 0; j < inputs.length; j++) {
            if(patterns[patternsIndex] == inputs[j]){
                patternsIndex++;
            }else{
                if(patterns[patternsIndex] != '*')  return false;
                else{
                    if(lengthAfterStar == inputs.length - j - 1) patternsIndex++;
                }
            }
        }
        return true;
    }

    /*
    _3.
    a*da
    asbcvdewda
    asdf*d
    a*sadfd

    1. patterns이 알파벳 소문자일때
    2. patterns이 별포일때
        2-1. 별포 다음 값이 inputs에 나오는 경우
            2-1-1 별표 다음 값이 input에 나왔는데 그 이후에 값이 또 있을 경우
        2-2. 별표 다음 값이 안나오는경우

    _4.
    별포는 문자열 시작과 끝에 X



     */

}