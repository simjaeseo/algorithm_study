import java.util.*;
import java.io.*;

public class Main {
    static int A,B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        process();
    }

    private static void process() {

        int number = B;
        int count = 0;

        while(number != A && number >= 1){
            if(number % 10 == 1){
                number = number / 10;
            }else if(number % 2 == 0){
                number = number / 2;
            }else{
                count = -1;
                break;
            }
            count++;
        }
//42 21 2 1
        if(number == A){
            System.out.println(count+1);
        }else if(count == -1){
            System.out.println(-1);
        }else{
            System.out.println(-1);
        }
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }
}

//2 162
//2 4 8 81 162
//
//100 40021
//100 200 2001 4002 40021
//
//1 222
//1 11 111 222
//
//
//1,000,000,000
//1-> x2
//2-> x10 + 1
//
//162