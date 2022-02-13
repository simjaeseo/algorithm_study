package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1011_FlymetotheAlphaCentauri {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int distance = y-x;
			int max = (int) Math.sqrt(y-x);
			int cnt=0;
			
			if(max*max == distance) {
				cnt = max*2-1;
			}else if(distance<= max*max+max){
				cnt = max*2;
			}else {
				cnt = max*2+1;
			}
			System.out.println(cnt);
			
			
			
				
			}

		}

}
