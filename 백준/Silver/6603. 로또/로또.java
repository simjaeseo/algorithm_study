import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, numbers[], inputs[];
    static boolean[] isSelected;
//    static ArrayList<Integer> l = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();


        print();

    }

    private static void print() {
        sb.delete(sb.length()-1, sb.length());
        System.out.print(sb);
    }


    private static void progress() {

        combination(0, 0);

    }

    private static void combination(int startIndex, int numberOfDraw) {
        if(numberOfDraw == 6){

            for(int number : numbers){
                sb.append(number).append(' ');
            }
            sb.delete(sb.length()-1, sb.length());
            sb.append('\n');

            return;
        }

        for (int i = startIndex; i < N; i++) {
            numbers[numberOfDraw] = inputs[i];

            combination(i + 1, numberOfDraw+1);
        }

    }

    private static void init() throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            if(N == 0)  break;

            inputs = new int[N];
            numbers = new int[6];

            int index = 0;
            while(st.hasMoreTokens()){
                inputs[index++] = Integer.parseInt(st.nextToken());
            }

            progress();
            sb.append('\n');

        }


    }


}