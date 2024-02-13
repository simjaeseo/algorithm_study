import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, roadDistance[], oilPrice[], index, nowOilPrice, roadDistanceSum, result;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        progress();

    }

    private static void progress() {
        index = 0;

        while(index < N-1) {
            nowOilPrice = oilPrice[index];
            roadDistanceSum = 0;

            while (true) {
                if (index == N - 1) break;

                if (oilPrice[index + 1] >= nowOilPrice) {
                    roadDistanceSum += roadDistance[index];
                    index++;
                }else if (oilPrice[index + 1] < nowOilPrice) {
                    roadDistanceSum += roadDistance[index];
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

        roadDistance = new int[N - 1];
        oilPrice = new int[N];

        st = new StringTokenizer(br.readLine());

        index = 0;
        while (st.hasMoreTokens()) {
            roadDistance[index++] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        index = 0;
        while (st.hasMoreTokens()) {
            oilPrice[index++] = Integer.parseInt(st.nextToken());
        }
    }


}