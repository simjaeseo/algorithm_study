import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int M;
    static String[] command;
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

//        solve(command[0], Integer.parseInt(command[1]));
    }


    private static void solve(String command, int x) {

    }


    private static void init() throws IOException {
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            command = br.readLine().split(" ");
//            System.out.println(command.length);


            if(command[0].equals("add")){
                set.add(Integer.parseInt(command[1]));
            }else if(command[0].equals("remove")){
                if(set.contains(Integer.parseInt(command[1]))) set.remove(Integer.parseInt(command[1]));
            }else if(command[0].equals("check")){
                if(set.contains(Integer.parseInt(command[1]))) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }else if(command[0].equals("toggle")){
                if(set.contains(Integer.parseInt(command[1]))) set.remove(Integer.parseInt(command[1]));
                else set.add(Integer.parseInt(command[1]));
            }else if(command[0].equals("all")){
                set.clear();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            }else if(command[0].equals("empty")){
                set.clear();
            }

        }
        if(sb.length() >= 1)      sb.delete(sb.length()-1, sb.length());
        System.out.print(sb);
    }

}