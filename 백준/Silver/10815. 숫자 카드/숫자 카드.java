import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int N;
    static ArrayList<Integer> originList = new ArrayList<>();
    static ArrayList<Integer> sortedList = new ArrayList<>();
    static Set<Integer> numberSet = new HashSet<>();
    static Map<Integer, Boolean> m = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        int sangguenCardSize = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            m.put(Integer.parseInt(st.nextToken()), true);
        }
        
        br.readLine();

        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()){
            if(m.containsKey(Integer.parseInt(st.nextToken()))){
                sb.append(1).append(' ');
            }else{
                sb.append(0).append(' ');
            }
        }

        System.out.println(sb.substring(0, sb.length()-1));

    }


}