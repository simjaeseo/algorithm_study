import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, map[][], maxCount;
    static int dr[] = new int[]{0,0,-1,1};
    static int dc[] = new int[]{-1,1,0,0};
    static ArrayList<Integer> l = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        progress();

        print();

    }

    private static void print() {
        sb.append(l.size()).append('\n');

        Collections.sort(l);
        for(int number : l){
            sb.append(number).append('\n');
        }
        sb.delete(sb.length()-1, sb.length());

        System.out.print(sb);
    }


    private static void progress() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1)  {
                    map[i][j] = 0;
                    maxCount = 1;
                    dfs(i,j);
                    l.add(maxCount);
                }
            }
        }

    }

    private static void dfs(int row, int col) {
        int mr = 0;
        int mc = 0;

        for (int i = 0; i < 4; i++) {
            mr = row + dr[i];
            mc = col + dc[i];

            if(mr < 0 || mc < 0 || mr >= N || mc >= N || map[mr][mc] == 0)  {
                continue;
            }

            maxCount++;
            map[mr][mc] = 0;
            dfs(mr,mc);
        }



    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();

            for (int j = 0; j < row.length(); j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }
    }


}