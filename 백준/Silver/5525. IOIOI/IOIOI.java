import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, countPn;
    static String s;
    static StringBuilder sb = new StringBuilder("I");
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
//        System.out.println(sb);
        System.out.println(countPn);
    }


    private static void solve() {
        boolean flag = false;

        // s의 0부터 s.length까지 탐색
        for (int i = 0; i < s.length(); i++) {
            if(s.length() - i < sb.length())    break;
            // 8 - 0 7
            if(s.charAt(i) == 'I'){

                //이전에 Pn이 체크 안되었다면,
                if(!flag){
                    boolean flag2 = false;
                    for (int j = 0; j < sb.length(); j++) {
                        if(sb.charAt(j) != s.charAt(i+j)) {
                            flag2 = true;
                            break;
                        }
                    }
                    if(flag2)   continue;
                    //여기까지 왔다는건, 일치한다는 의미
                    countPn++;
                    flag = true;
                    i++;
                }else{
                    int index = i + sb.length() - 2;

                    if(sb.charAt(sb.length()-2) != s.charAt(index)){
                        i += sb.length()-3;
                        flag = false;
                        continue;
                    }else if(sb.charAt(sb.length()-1) != s.charAt(index+1)){
                        i += sb.length()-2;
                        flag = false;
                        continue;
                    }
                    //i8
                    //sb.len 3

                    //여기까지 왔다는건, 일치한다는 의미
//                    System.out.println(i);
                    countPn++;
                    i++;
                } // 1010101
//  10101
//1010101010
//0123456789

//00101010
//01234567
//i = 4
            }
        }

    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            sb.append("OI");
        }
        M = Integer.parseInt(br.readLine());

        s = br.readLine();
    }

}