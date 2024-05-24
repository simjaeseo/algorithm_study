import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int wheels[][], directions[];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
    }

    private static void process() {
        int sum = 0;
        if (wheels[0][0] == 1) {
            sum+=1;
        }
        if (wheels[1][0] == 1) {
            sum+=2;
        }
        if (wheels[2][0] == 1) {
            sum+=4;
        }
        if (wheels[3][0] == 1) {
            sum+=8;
        }
        System.out.println(sum);


    }

    private static void init() throws IOException {
        wheels = new int[4][8];

        for (int i = 0; i < 4; i++) {
            char[] inputs = br.readLine().toCharArray();

            for (int j = 0; j < 8; j++) {
                wheels[i][j] = inputs[j] - '0';
            }
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            directions = new int[4];

            checkNS(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));

            rotation();
//            for (int j = 0; j < 4; j++) {
//                System.out.println(Arrays.toString(wheels[j]));
//            }
        }
    }

    private static void checkNS(int wheelNumber, int direction) {
        directions[wheelNumber] = direction;

        for (int i = wheelNumber; i > 0; i--) {
            if (wheels[i][6] != wheels[i - 1][2]) {
                directions[i-1] = directions[i] * -1;
            }else{
                break;
            }

        }

        for (int i = wheelNumber; i < 3; i++) {
            if (wheels[i][2] != wheels[i + 1][6]) {
                directions[i+1] = directions[i] * -1;
            }else{
                break;
            }
        }
    }

    private static void rotation() {


        for (int i = 0; i < 4; i++) {

            // N극 : 0, S극 : 1

            // 시계 : 1, 반시게: -1
            if (directions[i] == 1) {
                int temp = wheels[i][7];

                for (int j = 7; j > 0; j--) {
                    wheels[i][j] = wheels[i][j - 1];
                }

                wheels[i][0] = temp;
            } else if(directions[i] == -1){
                int temp = wheels[i][0];

                for (int j = 0; j < 7; j++) {
                    wheels[i][j] = wheels[i][j + 1];
                }

                wheels[i][7] = temp;
            }

        }


    }
}