import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r,c,k,map[][], minimumTime, countR = 3, countC= 3, maxR, maxC;
    static ArrayList<Number> numbers;
    static Map<Integer, Integer> m = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        process();


    }

    private static void process() {

        while(minimumTime <= 100){
            if(map[r-1][c-1] == k) {
                System.out.println(minimumTime);
                return;
            }

            minimumTime++;

            if(countR >= countC){
                R();
            }else{
                C();
            }

//            for (int i = 0; i < 10; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();
        }

        System.out.println(-1);
    }

    private static void R() {
        int newCountC = 0;
        for (int r = 0; r < countR; r++) {
            for (int i = 0; i < countC; i++) {
                if(map[r][i] != 0) m.put(map[r][i], m.getOrDefault(map[r][i], 0) + 1);
            }

            if(!m.isEmpty()){
                numbers = new ArrayList<>();

                for(Map.Entry<Integer, Integer> entry : m.entrySet()){
                    numbers.add(new Number(entry.getKey(), entry.getValue()));
                }

                Collections.sort(numbers);

                int index = 0;
                for(Number number : numbers){
                    if(index >= 100) break;
                    map[r][index++] = number.number;
                    map[r][index++] = number.count;
                }

                newCountC = Math.max(newCountC, index);
                for (int i = index; i < 100; i++) {
                    map[r][i] = 0;
                }
                m.clear();
            }
        }
        countC = newCountC;
    }

    private static void C() {
        int newCountR = 0;
        for (int c = 0; c < 100; c++) {
            for (int i = 0; i < 100; i++) {
                if(map[i][c] != 0) m.put(map[i][c], m.getOrDefault(map[i][c], 0) + 1);
            }

            if(!m.isEmpty()){
                numbers = new ArrayList<>();

                for(Map.Entry<Integer, Integer> entry : m.entrySet()){
                    numbers.add(new Number(entry.getKey(), entry.getValue()));
                }

                Collections.sort(numbers);

                int index = 0;
                for(Number number : numbers){
                    if(index >= 100)    break;
                    map[index++][c] = number.number;
                    map[index++][c] = number.count;
                }


                newCountR = Math.max(newCountR, index);
                for (int i = index; i < 100; i++) {
                    map[i][c] = 0;
                }
                m.clear();
            }
        }
        countR = newCountR;
    }


    private static void init() throws IOException {

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[100][100];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Number implements Comparable<Number>{
        int number;
        int count;

        public Number(int number, int count){
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Number o){
            if(this.count != o.count){
                return this.count - o.count;
            }else{
                return this.number - o.number;
            }
        }
    }
}