package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2477_참외밭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int[][] directionNlength = new int[6][2];
		int[] directionCnt = new int[5];
		int[] longXY = new int[2];
		int[] shortXY = new int[2];
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			directionNlength[i][0] = Integer.parseInt(st.nextToken());
			directionCnt[directionNlength[i][0]]++;
			directionNlength[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		int idx2 = 0;
		for (int i = 0; i < 6; i++) {
			if(directionCnt[directionNlength[i][0]] == 1)	{
				longXY[idx++] = directionNlength[i][1];
//				if()
			}
		}
		
		
		
		
		
	}
}
