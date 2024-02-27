import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, map[][], white, blue;
    static LinkedList<Meeting> meetings = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {
        Collections.sort(meetings);

        int count = 0;
        int endTime = 0;

        for(Meeting m : meetings){
            if(endTime <= m.start){
                endTime = m.end;
                count++;
            }
        }

        System.out.println(count);

    }


    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    public static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o1){
            if(this.end != o1.end){
                return this.end - o1.end;
            }else{
                return this.start - o1.start;
            }
        }
    }
}