import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> m = new HashMap<>();

        while(st.hasMoreTokens()){
            int dice = Integer.parseInt(st.nextToken());

            m.put(dice, m.getOrDefault(dice, 0) + 1);
        }

        Set<Integer> keySet = m.keySet();

        if(keySet.size() == 1){
            for(int key : keySet){
                System.out.println(10000+key*1000);
            }
        }else if(keySet.size() == 2){
            for(int key : keySet){
                if(m.get(key) == 2){
                    System.out.println(1000+key*100);
                }
            }
        }else{
            int max = 0;

            for (int key : keySet) {
                max = Math.max(max, key);
            }

            System.out.println(max * 100);

        }

    }
}