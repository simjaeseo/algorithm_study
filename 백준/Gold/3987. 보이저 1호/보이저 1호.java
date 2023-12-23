import java.io.*;
import java.util.*;


public class Main {
    static int N, M, Pr, Pc, maximumSecond = Integer.MIN_VALUE;
    static char resultDirection;
    static char[][] map;
    //좌하우상
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{-1,0,1,0};


    public static void main(String[] args) throws IOException {
        init();

        sendSignal();

        System.out.println(resultDirection);
        if(maximumSecond == N*M*2){
            System.out.println("Voyager");
        }else{
            System.out.println(maximumSecond);
        }


    }

    private static void sendSignal() {
        for (int i = 0; i < 4; i++) {
            int originDirectionIndex = i;
            int directionIndex = originDirectionIndex;

            int nextR = Pr;
            int nextC = Pc;

            int second = 0;

            while(true){
                nextR = nextR + dr[directionIndex];
                nextC = nextC + dc[directionIndex];

                second++;

                if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= M)    break;
                if(map[nextR][nextC] == 'C')    break;
                if(second >= N * M * 2)  break;

                if(map[nextR][nextC] == '/' || map[nextR][nextC] == '\\'){
                    directionIndex = changeDirection(map[nextR][nextC], directionIndex);
                }

            }

            if(maximumSecond <= second){
                maximumSecond = second;

                if(originDirectionIndex == 0){
                    // 좌
                    resultDirection = 'L';
                }else if(originDirectionIndex == 1){
                    // 하
                    resultDirection = 'D';
                }else if(originDirectionIndex == 2){
                    // 우
                    resultDirection = 'R';
                }else if(originDirectionIndex == 3){
                    // 상
                    resultDirection = 'U';
                }
            }
        }

    }

    private static int changeDirection(char planet, int directionIndex) {

        if(planet == '/'){
            //좌하우상

            if(directionIndex == 0){
                // 좌
                directionIndex = 1;
            }else if(directionIndex == 1){
                // 하
                directionIndex = 0;
            }else if(directionIndex == 2){
                // 우
                directionIndex = 3;
            }else if(directionIndex == 3){
                // 상
                directionIndex = 2;
            }

        }else if(planet == '\\'){

            if(directionIndex == 0){
                // 좌
                directionIndex = 3;
            }else if(directionIndex == 1){
                // 하
                directionIndex = 2;
            }else if(directionIndex == 2){
                // 우
                directionIndex = 1;
            }else if(directionIndex == 3){
                // 상
                directionIndex = 0;
            }
        }

        return directionIndex;


    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        Pr = Integer.parseInt(st.nextToken()) - 1;
        Pc = Integer.parseInt(st.nextToken()) - 1;

    }
}