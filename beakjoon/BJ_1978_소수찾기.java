package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1978_소수찾기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 1)	continue;
			
			boolean check = false;
			for (int j = 2; j < num; j++) {
				if(num%j == 0)	check = true;
			}
			
			if(!check)	cnt++;
			
			
			
			
		}
		
		System.out.println(cnt);
		
		
	}

}
