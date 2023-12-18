import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int N;
    static ArrayList<Integer> originList = new ArrayList<>();
    static ArrayList<Integer> sortedList = new ArrayList<>();
    static Set<Integer> numberSet = new HashSet<>();
    static Map<Integer, Integer> m = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int number = Integer.parseInt(st.nextToken());

            originList.add(number);
            numberSet.add(number);
        }

        sortedList.addAll(numberSet);
        Collections.sort(sortedList);

        for (int i = 0; i < sortedList.size(); i++) {
            m.put(sortedList.get(i), i);
        }


        StringBuilder sb = new StringBuilder();

        for(int number : originList){
            sb.append(m.get(number)).append(' ');
        }

        System.out.println(sb.substring(0, sb.length()-1));

    }


}