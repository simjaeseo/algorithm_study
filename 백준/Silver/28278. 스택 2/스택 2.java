import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Stack<Integer> s = new Stack<>();
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
            int command = Integer.parseInt(st.nextToken());

            if(command == 1){
                int number = Integer.parseInt(st.nextToken());

                s.add(number);
            }else if(command == 2){
                if(s.isEmpty()){
                    sb.append(-1).append('\n');
                }else{
                    sb.append(s.pop()).append('\n');
                }
            }else if(command == 3){
                sb.append(s.size()).append('\n');
            }else if(command == 4){
                if(s.isEmpty()){
                    sb.append(1).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }else if(command == 5){
                if(s.isEmpty()){
                    sb.append(-1).append('\n');
                }else{
                    sb.append(s.peek()).append('\n');
                }
            }
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);

    }



}