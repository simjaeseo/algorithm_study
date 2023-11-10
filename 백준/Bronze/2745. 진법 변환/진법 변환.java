import java.io.*;
import java.util.*;


public class Main {
    static double sumScore, sumGrade;
    static int N,sum;
    static char[] inputs;
    static char[][] map = new char[5][15];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        changeTenRule();

        System.out.println(sum);

    }

    private static void changeTenRule() {
        int positionNumber = 0;

        int index = 0;
        for (int i = inputs.length - 1; i >= 0; i--) {
            positionNumber = (int) Math.pow(N, index++);

            sum += positionNumber * changeNumber(inputs[i]);

        }

    }

    private static int changeNumber(char input) {
        if(input >= 'A' && input <= 'Z'){
            return input - 'A' + 10;
        }else{
            return input - '0';
        }
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        inputs = st.nextToken().toCharArray();
        N = Integer.parseInt(st.nextToken());
    }


}