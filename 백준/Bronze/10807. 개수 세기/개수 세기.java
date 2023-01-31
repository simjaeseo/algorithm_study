import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int index = 0;

        while (st.hasMoreTokens()){
            array[index++] = Integer.parseInt(st.nextToken());
        }

        int v = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int number : array){
            if(v == number)
                answer++;
        }

        System.out.println(answer);
    }
}