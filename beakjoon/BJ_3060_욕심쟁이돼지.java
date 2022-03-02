package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3060_욕심쟁이돼지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] pig = new int[6];
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 6; j++) {
				pig[j] = Integer.parseInt(st.nextToken());
			}
			
			int day = 1;
			int idx = 0;
			int food = N;
			int[] tmp = new int[6];
			tmp = Arrays.copyOfRange(pig, 0, 6);
			while(food>0) {
				food -= pig[idx];
				idx++;
				
				if(food<0 ) break;
				else if(idx == 6) {
					day++;
					idx = 0;
					for (int j = 0; j < 6; j++) {
						pig[j] += tmp[j-1<0?5:j-1] + tmp[(j+1)%6] + tmp[(j+3)%6];
					}
					
					for (int j = 0; j < 6; j++) {
						tmp[j] = pig[j];
					}
					food = N;
				}
			}
			System.out.println(day);
		}
	}

}
