import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String string;
    static int leftCount, changeCount, number = 1;

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        solve();
    }


    private static void solve() throws IOException {

        while(true){
            string = br.readLine();
            if(string.charAt(0) == '-') break;

            leftCount = 0;
            changeCount = 0;

            for (int i = 0; i < string.length(); i++) {
                char character = string.charAt(i);

                if(character == '{'){
                    leftCount++;
                }else if(character == '}'){

                    if(leftCount == 0){
                        changeCount++;
                        leftCount++;
                    }else{
                        leftCount--;
                    }
                }
            }

            changeCount += leftCount / 2;

            System.out.println(number++ + ". " + changeCount);
        }

        
    }
}