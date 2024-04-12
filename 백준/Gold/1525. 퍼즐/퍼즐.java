import java.util.*;
import java.io.*;

public class Main {
    static String puzzle = "";
    static String originPuzzle = "123456780";
    static StringBuilder newPuzzle;
    static Map<String, Integer> isVisitedMap = new HashMap<>();
    static int K, W, H, map[][], result;
    static boolean isVisited[][][];
    static int[] dr = new int[]{0, 0, 1, -1};
    static int[] dc = new int[]{1, -1, 0, 0};
    static int[] horseDr = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] horseDc = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {

        Queue<String> q = new ArrayDeque<>();

        q.add(puzzle); // 2차원배열일때의 행과 열 넣어주기
        isVisitedMap.put(puzzle , 0);

        while(!q.isEmpty()){
            puzzle = q.poll();

            int zeroIndex = puzzle.indexOf("0");
            int zeroR = zeroIndex / 3;
            int zeroC = zeroIndex % 3;

            if(originPuzzle.equals(puzzle)) {
                System.out.println(isVisitedMap.get(puzzle));
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextZeroR = zeroR + dr[i];
                int nextZeroC = zeroC + dc[i];

                if(nextZeroR < 0 || nextZeroC < 0 || nextZeroR >= 3 || nextZeroC >= 3)  continue;

                int nextZeroIndex = nextZeroR * 3 + nextZeroC;

                newPuzzle = new StringBuilder(puzzle);
                char tempChar = newPuzzle.charAt(nextZeroIndex);
                newPuzzle.setCharAt(nextZeroIndex, '0');
                newPuzzle.setCharAt(zeroR * 3 + zeroC, tempChar);

                if(!isVisitedMap.containsKey(newPuzzle.toString())){
                    q.add(newPuzzle.toString());
                    isVisitedMap.put(newPuzzle.toString(), isVisitedMap.get(puzzle) + 1);

                }
            }
        }

        System.out.println(-1);
    }

    private static void init() throws IOException {

        for (int i = 0; i < 3; i++) {
            puzzle += br.readLine().replaceAll(" ", "");
        }
    }
}