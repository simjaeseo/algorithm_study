import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static String input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        if(sb.toString().equals(sb.reverse().toString())){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb.append(br.readLine());



    }

}