import java.io.*;
import java.util.*;

class Main {
    static int S;
    static boolean[][] visited; // 방문 체크 배열
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        S = Integer.parseInt(br.readLine());
        
        // 문제 조건에 따라 범위 설정(예: 이모티콘 수와 클립보드 수 모두 최대 2,000 정도로 가정)
        visited = new boolean[2001][2001];
        
        // BFS
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0, 0}); // 시작: (화면 이모티콘=1, 클립보드=0, 시간=0)
        visited[1][0] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int emoticon = current[0];
            int clip = current[1];
            int time = current[2];

            // 목표 도달
            if(emoticon == S) {
                System.out.println(time);
                return;
            }

            // 1. 클립보드에 복사
            // clipboard != emoticon 조건은 없어도 되지만, 중복 연산을 줄일 때는 검토 가능
            if(!visited[emoticon][emoticon]) {
                visited[emoticon][emoticon] = true;
                q.add(new int[]{emoticon, emoticon, time+1});
            }

            // 2. 클립보드에서 화면에 붙여넣기 (clip > 0 이면 붙여넣기 가능)
            int nextEmoticon = emoticon + clip;
            if(clip > 0 && nextEmoticon < 2001 && !visited[nextEmoticon][clip]) {
                visited[nextEmoticon][clip] = true;
                q.add(new int[]{nextEmoticon, clip, time+1});
            }

            // 3. 이모티콘 하나 삭제 (화면에 1개 이상 있어야 함)
            if(emoticon > 1 && !visited[emoticon-1][clip]) {
                visited[emoticon-1][clip] = true;
                q.add(new int[]{emoticon-1, clip, time+1});
            }
        }
    }
}
