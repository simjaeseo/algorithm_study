package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3040_백설공주와일곱난쟁이 {
	static int[] seven = new int[7];
	static int[] nanjaeng;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		nanjaeng = new int[9];
		
		for (int i = 0; i < 9; i++) {
			nanjaeng[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0,0);
		
	}
	
	public static void combination(int cnt, int startIdx) {
		if(cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += seven[i];
			}
			if(sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(seven[i]);
				}
			}
			return;
			
		}
		
		
		for (int i = startIdx; i < 9; i++) {
			
			seven[cnt] = nanjaeng[i];
			combination(cnt+1, i+1);
		}
		
	}
	
	

}
