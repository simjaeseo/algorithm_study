package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_6808_규영이와인영이의카드게임 {
	static int[] numbers, inyoung, gyuyoung;
	static boolean[] isSelected = new boolean[9];
	static int win, lose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		numbers = new int[9];
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			boolean[] isSelected = new boolean[19];
			gyuyoung = new int[9];
			inyoung = new int[9];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				gyuyoung[j] = num;
				isSelected[num] = true;
			}
			
			int idx =0;
			for (int j = 1; j < 19; j++) {
				if(isSelected[j])	continue;
				inyoung[idx++] = j;
			}
			
			permutation(0);
			System.out.println("#" + i + " " + win + " "+ lose);
			win = 0;
			lose = 0;
		}
	}
	
	
	public static void permutation(int cnt) {
		if(cnt == 9) {
			int gyuScore = 0;
			int inScore = 0;
			for (int i = 0; i < 9; i++) {
				if(gyuyoung[i] > numbers[i]) {
					gyuScore += gyuyoung[i] + numbers[i];
				}else if(gyuyoung[i] < numbers[i]) {
					inScore += gyuyoung[i] + numbers[i];
				}
			}
			if(gyuScore > inScore) 	win++;
			else if (gyuScore< inScore) lose++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(isSelected[i])	continue;
			numbers[cnt] = inyoung[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	

}
