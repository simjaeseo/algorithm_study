import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1){
            return;
        }

        int index = 2;

        while(N != 1){
            if(N%index == 0){
                N /= index;
                System.out.println(index);
            }else{
                while(N%index != 0){
                    index++;
                }
            }
        }
    }
}