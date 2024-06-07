import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,X,Y,D,G, result, map[][] = new int[101][101];
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};

    static ArrayList<Integer> curves ;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1) result++;
            }
        }
        System.out.println(result);
    }


    // 다음 탐색순서 = 이전까지의 방향 순서의 역순의 대응되는 방향
    // 0-1
    // 1-2
    // 2-3
    // 3-2

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            curves = new ArrayList<>();
            curves.add(D);
            map[Y][X] = 1;

            generateDragonCurv();
        }
    }

    private static void generateDragonCurv() {

        for (int i = 0; i < G; i++) {
            int size = curves.size()-1;
            for (int j = size; j >= 0; j--) {
                curves.add((curves.get(j) + 1) % 4);
            }
        }

        int mx = X;
        int my = Y;
        for (int i = 0; i < curves.size(); i++) {
            mx += dx[curves.get(i)];
            my += dy[curves.get(i)];

            if(mx < 0 || my < 0 || mx >= 101 || my >= 101) continue;

            map[my][mx] = 1;
        }


    }
}