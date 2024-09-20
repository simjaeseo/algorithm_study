import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static List<int[]> brackets = new ArrayList<>();
    static Set<String> result = new TreeSet<>();
    static boolean isSelected[];

    static StringBuilder origin = new StringBuilder();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < origin.length(); i++) {
            if(origin.charAt(i) == '('){
                stack.push(i);
            }else if(origin.charAt(i) == ')'){
                int left = stack.pop();
                int right = i;
                brackets.add(new int[]{left, right});
            }
        }

        isSelected = new boolean[brackets.size()];

        subset(0);

        result.remove(origin.toString()); // 원본 수식은 제외

        for (String res : result) {
            System.out.println(res);
        }

    }

    // 함수 안에 for문 넣는경우?
    private static void subset(int count) {
        if(count == brackets.size()){
            boolean zeroSet = false;

            StringBuilder sb = new StringBuilder(origin);

            for (int i = 0; i < brackets.size(); i++) {
                if(isSelected[i]){
                    sb.setCharAt(brackets.get(i)[0], ' ');
                    sb.setCharAt(brackets.get(i)[1], ' ');
                    zeroSet = true;
                }
            }
            if(!zeroSet) return;

            result.add(sb.toString().replaceAll(" ", ""));
            return;
        }


        isSelected[count] = true;
        subset(count+1);

        isSelected[count] = false;
        subset(count+1);
    }


    private static void init() throws IOException {
        String input = br.readLine();

        origin = new StringBuilder(input);
    }

}
