import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, map[][], count;
    static boolean isVisited[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        for (int i = 0; i < N; i++) {
            if(checkRoad(map[i], i)){
                count++;
            }
        }

        for (int i = 0; i < N; i++) {
            int[] road = new int[N];
            for (int j = 0; j < N; j++) {
                road[j] = map[j][i];
            }

            if(checkRoad(road, i)){
                count++;
            }
        }

        System.out.println(count);

    }

    private static boolean checkRoad(int[] road, int num) {
        isVisited = new boolean[N];

        for (int i = 0; i < N-1; i++) {
            if(road[i] == road[i+1]) continue;
            else if(road[i] + 1 == road[i+1]){
                for (int j = 0; j < L; j++) {
                    if(i-j <0 || isVisited[i-j] || road[i-j] != road[i])  return false;
                    isVisited[i-j] = true;
                }
            }else if(road[i] == road[i+1]+1){
                for (int j = 0; j < L; j++) {
                    if(i+1+j >= N || isVisited[i+1+j] || road[i+1+j] != road[i+1])    return false;
                    isVisited[i+1+j] = true;
                }
            }else   return false;
        }
        return true;

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }


}