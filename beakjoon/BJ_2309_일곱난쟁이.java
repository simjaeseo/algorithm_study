package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이 {
	static int[] nanjaeng = new int[9];
	static int[] tmp = new int[7];
	static int[] seven = new int[7];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			nanjaeng[i] = Integer.parseInt(br.readLine());
		}
		
		combi(0 , 0 , 0);
		
	}
	
	
	static boolean flag = false;
	public static void combi(int cnt, int idx, int sum) {
		if(flag) return;
		
		if(cnt == 7) {
			if(sum == 100) {
				flag = true;
				Arrays.sort(tmp);
				for (int i = 0; i < 7; i++) {
					System.out.println(tmp[i]);
					
				}
			}
			return;
		}
		
		for (int i = idx; i < 9; i++) {
			tmp[cnt] = nanjaeng[i];
			combi(cnt+1,i+1,sum+nanjaeng[i]);
			
		}
		
		 
		
		
	}

}
