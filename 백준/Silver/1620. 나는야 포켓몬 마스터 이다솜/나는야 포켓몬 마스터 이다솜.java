import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Set<String> set = new HashSet<>();
    static Set<String> set2 = new TreeSet<>(Collections.reverseOrder());
    static Map<String, Integer> map = new HashMap<>();
    static Map<Integer, String> map2 = new TreeMap<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();

            map.put(name, i);
            map2.put(i, name);
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();

            if(map.containsKey(name)){
                sb.append(map.get(name)).append('\n');
            }else{
                sb.append(map2.get(Integer.parseInt(name))).append('\n');
            }
        }

        sb.delete(sb.length()-1 , sb.length());

        System.out.println(sb);

    }


}