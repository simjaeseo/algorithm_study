import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Set<String> set = new HashSet<>();
    static Set<String> set2 = new TreeSet<>(Collections.reverseOrder());
    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, String> map2 = new TreeMap<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int number = Integer.parseInt(st.nextToken());

            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int number = Integer.parseInt(st.nextToken());

            if(map.get(number) == null){
                sb.append(0).append(' ');
            }else{
                sb.append(map.get(number)).append(' ');
            }

        }

        sb.delete(sb.length()-1, sb.length());

        System.out.println(sb);


    }


}