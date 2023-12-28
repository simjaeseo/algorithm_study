import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Stack<Integer> originLine = new Stack<>();
    static Stack<Integer> tempLine = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = n - 1; i >= 0; i--) {
            originLine.add(array[i]);
        }

        int order = 1;
        int previousTempLineSize = 0;

        while (true) {

            if (originLine.isEmpty() && tempLine.isEmpty()) {
                sb.append("Nice");
                break;
            }

            if (originLine.isEmpty() && !tempLine.isEmpty()) {
                previousTempLineSize = tempLine.size();
            }


            // 원래 줄이 안비어있고, 맨 앞사람이 해당 순서라면,
            if (!originLine.isEmpty() && originLine.peek() == order) {
                order = originLine.pop() + 1;
            } else if (!originLine.isEmpty() && originLine.peek() != order) {
                //원래 줄이 안비어있고, 맨 앞사람이 해당 순서가 아니라면,

                if (!tempLine.isEmpty() && tempLine.peek() == order) {
                    order = tempLine.pop() + 1;
                } else if (!tempLine.isEmpty() && tempLine.peek() != order) {
                    tempLine.add(originLine.pop());
                } else if (tempLine.isEmpty()) {
                    tempLine.add(originLine.pop());
                }
            }else if(originLine.isEmpty() && tempLine.peek() == order){
                order = tempLine.pop() + 1;
            }


            if (originLine.isEmpty() && !tempLine.isEmpty()) {
                if (previousTempLineSize == tempLine.size()) {
                    sb.append("Sad");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}