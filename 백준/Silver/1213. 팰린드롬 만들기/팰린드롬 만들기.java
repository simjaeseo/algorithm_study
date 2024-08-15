import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String str;
    static Map<Character, Integer> map = new TreeMap<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        int oddCount = 0;
        char oddCharacter = '1';

        for(char c : map.keySet()){
            if(map.get(c) % 2 != 0){
                oddCharacter = c;
                oddCount++;
            }
        }

        if(oddCount >= 2){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for(char c : map.keySet()){
            for (int i = 0; i < map.get(c) / 2; i++) {
                sb.append(c);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb);

        if(oddCount == 1) sb2.append(oddCharacter);

        sb2.append(sb.reverse());
        System.out.println(sb2);
    }


    private static void init() throws IOException {
        str = br.readLine();
    }

}