import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int N;
    static LinkedList<char[]> l = new LinkedList<>();
    static Set<String> vocaSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        init();

    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());



        for (int i = 0; i < N; i++) {
            vocaSet.add(br.readLine());
        }

        vocaSet.forEach(voca -> {
            char[] inputs = voca.toCharArray();
            l.add(inputs);
        });

        Collections.sort(l, (o1, o2) -> {

            if(o1.length != o2.length){
                return o1.length - o2.length;
            }else{
                for (int i = 0; i < o1.length; i++) {
                    if(o1[i] == o2[i])  continue;
                    return o1[i] - o2[i];
                }
            }
            return 0;
            });

        StringBuilder sb = new StringBuilder();

        for(char[] inputs : l){
            for(char input : inputs){
                sb.append(input);
            }
            sb.append('\n');
        }

        sb.substring(0,sb.length()-1);

        System.out.println(sb);

    }

}