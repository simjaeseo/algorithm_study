import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long N, roadDistance[], oilPrice[], index, nowOilPrice, roadDistanceSum, result;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        progress();

    }

    private static void progress() {
        index = 0;

        while(index < N-1) {
            nowOilPrice = oilPrice[(int) index];
            roadDistanceSum = 0;

            while (true) {
                if (index == N - 1) break;

                if (oilPrice[(int) (index + 1)] >= nowOilPrice) {
                    roadDistanceSum += roadDistance[(int) index];
                    index++;
                }else if (oilPrice[(int) (index + 1)] < nowOilPrice) {
                    roadDistanceSum += roadDistance[(int) index];
                    index++;
                    break;
                }

            }
            result += nowOilPrice * roadDistanceSum;
        }

        System.out.println(result);

    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        roadDistance = new long[(int) (N - 1)];
        oilPrice = new long[(int) N];

        st = new StringTokenizer(br.readLine());

        index = 0;
        while (st.hasMoreTokens()) {
            roadDistance[(int) index++] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        index = 0;
        while (st.hasMoreTokens()) {
            oilPrice[(int) index++] = Integer.parseInt(st.nextToken());
        }
    }


}