import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String s;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        for (int i = 0; i < s.length(); i++) {
            if(isPalindrome(s.substring(i))){
                System.out.println(s.length() + i);
                break;
            }
        }

    }

    private static boolean isPalindrome(String substring) {
        int left = 0 ;
        int right = substring.length()-1;

        while(left < right){

            if(substring.charAt(left) != substring.charAt(right)) return false;

            left++;
            right--;
        }
        return true;
    }


    private static void init() throws IOException {
        s = br.readLine();
    }

}