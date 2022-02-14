package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961_도영이가만든맛있는음식 {
	static int N;
	static boolean[] isSelected;
	static int[][] gradient;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		gradient = new int[N][2];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 2; j++) {
				gradient[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		generateSubset(0);
		System.out.println(min);
	}
	
	
	public static void generateSubset(int cnt) {
		int zeroFlag = 0;
		
		if(cnt == N) {
			int sour = 1;
			int bitter = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sour *= gradient[i][0];
					bitter += gradient[i][1];
				}else {
					zeroFlag++;
				}
			}
			if(zeroFlag == N)	return;
			if(min> Math.abs(sour-bitter)) {
				min = Math.abs(sour-bitter);
			}
			
			return;
		}
		
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		isSelected[cnt] = false;
		generateSubset(cnt+1);
			
			
		
		
		
	}
	
	

}
