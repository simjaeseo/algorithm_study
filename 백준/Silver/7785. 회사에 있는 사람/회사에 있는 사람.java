import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Set<String> set = new HashSet<>();
    static Set<String> set2 = new TreeSet<>(Collections.reverseOrder());
    static Map<String, Boolean> map = new HashMap<>();
    static Map<String, Boolean> map2 = new TreeMap<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String command = st.nextToken();

            if(command.equals("enter")){
                set2.add(name);
            }else{
                set2.remove(name);
            }
        }


        for(String name : set2){
            sb.append(name).append('\n');
        }

        sb.delete(sb.length()-1, sb.length());

        System.out.println(sb);

    }


}