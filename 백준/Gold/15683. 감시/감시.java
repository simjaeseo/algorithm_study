import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, map[][], countCctvAndWall, minimumRectangleSite = Integer.MAX_VALUE;
//    static boolean isVisited[];
    static ArrayList<int[]> cctvs = new ArrayList<>();
    static ArrayList<int[][]> cctvTypes = new ArrayList<>();
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{1,0,-1,0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {

        dfs(0,0, new boolean[N][M]);

        System.out.println(minimumRectangleSite);
//        System.out.println(Arrays.toString(cctvTypes.get(0)[0]));

    }

    private static void dfs(int number, int count, boolean[][] isVisited) {
        if(count == cctvs.size()){
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(isVisited[i][j]) sum++;
                }
            }

            minimumRectangleSite = Math.min(minimumRectangleSite, N*M - sum - countCctvAndWall);
//            if(minimumRectangleSite == -2){
//                for (int i = 0; i < N; i++) {
//                    System.out.println(Arrays.toString(isVisited[i]));
//                }
//                System.out.println();
//            }
            return;
        }

        // 맵에 있는 각각의 cctv가 취할 수 있는 방향들을 모두 체크해보기

        int[] cctv = cctvs.get(number);
        int cctvNumber = cctv[0];
        int cctvR = cctv[1];
        int cctvC = cctv[2];

//        int[] cctvDirections = cctvTypes.get(number)[cctvNumber];
        int[][] cctvType = cctvTypes.get(cctvNumber);

        for(int[] cctvDirections : cctvType){
            boolean[][] newIsVisited = deepCopy(isVisited);

            for(int cctvDirection : cctvDirections){
                int mr = cctvR;
                int mc = cctvC;
//                System.out.println(cctvDirection);

                while(true){
                    mr += dr[cctvDirection];
                    mc += dc[cctvDirection];

                    if(mr < 0 || mc < 0 || mr>= N || mc>= M ||map[mr][mc] == 6) break;

                    if(map[mr][mc] == 0){
                        newIsVisited[mr][mc] = true;
                    }

                }

            }
            dfs(number+1, count+1, newIsVisited);
        }
    }

    private static boolean[][] deepCopy(boolean[][] original) {
        if (original == null) {
            return null;
        }

        boolean[][] result = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] > 0)   countCctvAndWall++;
                if(map[i][j] > 0 && map[i][j] != 6)   cctvs.add(new int[]{map[i][j]-1, i, j});
            }
        }

        cctvTypes.add(new int[][]{{0},{1},{2},{3}});
        cctvTypes.add(new int[][]{{0,2},{1,3}});
        cctvTypes.add(new int[][]{{0,3},{2,3},{1,2},{0,1}});
        cctvTypes.add(new int[][]{{0,2,3},{1,2,3},{0,1,2},{0,1,3}});
        cctvTypes.add(new int[][]{{0,1,2,3}});
    }


}