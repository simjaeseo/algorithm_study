import java.io.*;
import java.util.*;


public class Main {
    static double sumScore, sumGrade;
    static int N, A, B, K;
    static char[] inputs;
    static char[][] map = new char[5][15];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        boolean flag = false;
        int index = 0;
        for (int i = 1; i <= N; i++) {
            if(N%i == 0)    {
                index++;

                if(index == K) {
                    System.out.println(i);
                    flag = true;
                }
            }
        }
        if(!flag) System.out.println(0);

    }


}