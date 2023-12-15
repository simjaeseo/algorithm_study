import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int N;
    static LinkedList<int[]> l = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init();

    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());



        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            l.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

        Collections.sort(l, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(int[] position : l){
            sb.append(position[0]).append(' ').append(position[1]).append('\n');
        }
        
        sb.substring(0,sb.length()-1);

        System.out.println(sb);

    }

}