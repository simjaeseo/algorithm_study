import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Set<String> set = new HashSet<>();
    static Map<String, Boolean> map = new HashMap<>();
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
                set.add(name);
            }else{
                set.remove(name);
            }
        }


        for(String name : set.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList())){
            sb.append(name).append('\n');
        }

        sb.delete(sb.length()-1, sb.length());

        System.out.println(sb);

    }


}