import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static char[] origin = {'q','u','a','c','k'};
    static char[] inputs;
    static boolean isSelected[];
    static int answer;
    static List<Character> list = new ArrayList<>();


    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        isSelected = new boolean[inputs.length];

        if(inputs.length % 5 != 0 || inputs[0] != 'q'){
            System.out.println(-1);
            return;
        }

        int index = 0;
        for (int i = 0; i < inputs.length; i++) {

            list = new ArrayList<>();

            for (int j = i; j < inputs.length; j++) {
                if(!isSelected[j] && inputs[j] == origin[index]){
                    list.add(inputs[j]);
                    isSelected[j] = true;
                    index++;

                    if(index == 5) index = 0;
                }
            }

            if(!list.isEmpty()){

                if(list.get(list.size() - 1) == 'k') answer++;
                else{
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);
    }


    private static void init() throws IOException {
        inputs = br.readLine().toCharArray();
    }
}
