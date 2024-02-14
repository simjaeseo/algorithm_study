import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,w,maxWeight, trucks[], time;
    static Deque<Truck> road = new ArrayDeque<>();
//    static ArrayList<Integer> l = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
//    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        progress();
        print();
    }

    private static void print() {
        System.out.println(time);
    }


    private static void progress() {
        int truckIndex = 0;
        int totalWeight = 0;

        while(true){

            if(!road.isEmpty() && road.getLast().distance == w )    {
                totalWeight -= road.pollLast().weight;
            }

            if(truckIndex < n && totalWeight + trucks[truckIndex] <= maxWeight ){
                totalWeight += trucks[truckIndex];
                road.addFirst(new Truck(trucks[truckIndex++], 0));
            }

            for(Truck t : road){
                t.distance++;
            }


            time++;

            if(truckIndex == n && road.isEmpty())  break;
        }

    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 트럭 수
        w = Integer.parseInt(st.nextToken()); // 다리 길이
        maxWeight = Integer.parseInt(st.nextToken()); // 최대 하중

        trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }
    }


    static class Truck{
        int weight;
        int distance;

        public Truck(int weight, int distance){
            this.weight = weight;
            this.distance = distance;
        }
    }


}