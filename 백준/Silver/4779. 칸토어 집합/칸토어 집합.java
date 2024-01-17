import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://velog.io/@somyeong0623/%EB%B0%B1%EC%A4%80java-4779.-%EC%B9%B8%ED%86%A0%EC%96%B4-%EC%A7%91%ED%95%A9
public class Main {
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            n = Integer.parseInt(s);
            sb = new StringBuilder();
            
            int len = (int) Math.pow(3, n);
            
            for (int i = 0; i < len; i++) {
                sb.append("-");
            }

            func(0, len);
            
            System.out.println(sb);
        }
    }

    public static void func(int start, int size) {
        if (size == 1) {
            return;
        }
        int newSize = size / 3;
        for (int i = start + newSize; i < start + 2 * newSize; i++) {
            sb.setCharAt(i, ' ');
        }

        func(start, newSize);
        func(start + 2 * newSize, newSize);
    }

}