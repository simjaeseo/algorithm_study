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
        String answer = "Nice";

        while(!originLine.isEmpty()){

            if(originLine.peek() == order){
                originLine.pop();
                order++;
            }else if(originLine.peek() != order && tempLine.isEmpty()){
                tempLine.add(originLine.pop());
            }else if(originLine.peek() != order && tempLine.peek() == order){
                tempLine.pop();
                order++;
            }else if(originLine.peek() != order && tempLine.peek() != order){
                tempLine.add(originLine.pop());
            }
        }
        while(!tempLine.isEmpty()){
            if(tempLine.peek() == order){
                tempLine.pop();
                order++;
            }else{
                answer = "Sad";
                break;
            }
        }


        System.out.println(answer);
    }
}