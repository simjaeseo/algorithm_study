import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static char map[][];
    static int numbers[], answer;
    static boolean m[][], isVisited[][];
    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        combination(0,0);

        System.out.println(answer);


    }

    private static void combination(int count, int startIndex) {
        if(count == 7){
            int r = 0;
            int c = 0;

            for (int i = 0; i < 7; i++) {
                r = numbers[i] / 5;
                c = numbers[i] % 5;

                m[r][c] = true;
            }


            bfs(r,c);

            for (int i = 0; i < 7; i++) {
                r = numbers[i] / 5;
                c = numbers[i] % 5;

                m[r][c] = false;
            }
            return;
        }

        for (int i = startIndex; i < 25; i++) {
            numbers[count] = i;
            combination(count+1, i+1);
        }
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        isVisited = new boolean[5][5];
        q.add(new int[]{r,c});
        isVisited[r][c] = true;

        int yCount = 0;
        int sCount = 0;
        int connectCount = 1;

        if(map[r][c] == 'Y') yCount++;
        else sCount++;

        while(!q.isEmpty()){
            int[] current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = current[0] + dr[i];
                int nextC = current[1] + dc[i];

                if(nextR < 0 || nextC < 0 || nextR>= 5 || nextC >= 5) continue;
                if(!m[nextR][nextC] || isVisited[nextR][nextC]) continue;

                q.add(new int[]{nextR,nextC});
                if(map[nextR][nextC] == 'Y') yCount++;
                else sCount++;
                connectCount++;
                isVisited[nextR][nextC] = true;
            }

        }

        if(sCount >= 4 && connectCount == 7 ) answer++;


    }


    private static void init() throws IOException {
        map = new char[5][5];
        m = new boolean[5][5];
        numbers = new int[7];


        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }
    }
}
