import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Stack<Character> s = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
//        st = new StringTokenizer(br.readLine());

        while (true) {
            char[] inputs = br.readLine().toCharArray();

            if (inputs.length == 1 && inputs[0] == '.') break;

            boolean flag = false;

            for (char input : inputs) {

                if (input == '[' || input == '(') {
                    s.add(input);
                }

                if (input == ')') {
                    if (!s.empty() && s.peek() == '(') {
                        s.pop();
                    } else {
//                        sb.append("no").append('\n');
                        flag = true;
                        break;
                    }
                }

                if (input == ']') {
                    if (!s.empty() && s.peek() == '[') {
                        s.pop();
                    } else {
//                        sb.append("no").append('\n');
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag && s.size() == 0) {
                sb.append("yes").append('\n');
            }else{
                sb.append("no").append('\n');
            }
            s.clear();
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);


    }
}