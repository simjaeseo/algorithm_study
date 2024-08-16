import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, result;
    static int[] originVoca = new int[26], compareVoca;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(result);
    }


    private static void solve() {
        int changeCount = 0;
        int addCount = 0;
        int minusCount = 0;

        for (int i = 0; i < 26; i++) {
            if(compareVoca[i] == 0 && originVoca[i] != 0) minusCount += originVoca[i];
            if(compareVoca[i] != 0 && originVoca[i] == 0) addCount += compareVoca[i];
            if(compareVoca[i] != 0 && originVoca[i] != 0){
                if(compareVoca[i] > originVoca[i]){
                    addCount += Math.abs(compareVoca[i] - originVoca[i]);
                }else if(compareVoca[i] < originVoca[i]){
                    minusCount += Math.abs(compareVoca[i] - originVoca[i]);
                }

            }
        }

        int count = changeCount + addCount;

        if(minusCount > addCount)   count += Math.abs(addCount - minusCount);

        if(count <= 1) result++;

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        String string = br.readLine();

        for (int i = 0; i < string.length(); i++) {
            originVoca[string.charAt(i) - 'A']++;
        }

        for (int i = 0; i < N - 1; i++) {
            string = br.readLine();

            compareVoca= new int[26];

            for (int j = 0; j < string.length(); j++) {
                compareVoca[string.charAt(j) - 'A']++;
            }

            solve();
        }

    }

}