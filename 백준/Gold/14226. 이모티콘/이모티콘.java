import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int S;
    static boolean isVisited[][];

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {
        Queue<int[]> q = new ArrayDeque<>();
        // 이모티콘 개수 / 클립보드 개수 / 시간
        q.add(new int[]{1,0,0});

        // 문제 조건에 따라 범위 설정(예: 이모티콘 수와 클립보드 수 모두 최대 2,000 정도로 가정)
        // 2 <= S <= 1000
        isVisited = new boolean[2001][2001];
        isVisited[1][0] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int emoticonNumber = current[0];
            int clipboard = current[1];
            int time = current[2];

            if(emoticonNumber == S) {
                System.out.println(time);
                return;
            }

            // 클립보드 저장
            if(!isVisited[emoticonNumber][emoticonNumber] && clipboard != emoticonNumber){
                isVisited[emoticonNumber][emoticonNumber] = true;
                q.add(new int[]{emoticonNumber, emoticonNumber, time+1});
            }

            // 클립보드에 있는거 화면에 붙여넣기
            if(emoticonNumber + clipboard < 2001 && !isVisited[emoticonNumber + clipboard][clipboard] && clipboard > 0) {
                isVisited[emoticonNumber + clipboard][clipboard] = true;
                q.add(new int[]{emoticonNumber + clipboard, clipboard, time+1});
            }

            // 삭제
            if (!isVisited[emoticonNumber-1][clipboard] && emoticonNumber > 1) {
                isVisited[emoticonNumber-1][clipboard] = true;
                q.add(new int[]{emoticonNumber-1, clipboard, time+1});
            }
        }
    }


    private static void init() throws IOException {
        S = Integer.parseInt(br.readLine());
    }
}
