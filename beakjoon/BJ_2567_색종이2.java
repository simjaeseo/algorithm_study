package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2567_색종이2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] map = new int[101][101];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for (int j = y; j < y+10; j++) {
				for (int j2 = x; j2 < x+10; j2++) {
					map[j][j2] = 1;
				}
			}
		}
		int cnt = 0;
		
		for (int i = 0; i < map.length; i++) {
			if(map[99][i] == 1) cnt++;
			if(map[0][i] == 1) cnt++;
			if(map[i][99] == 1) cnt++;
			if(map[i][0] == 1) cnt++;
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				if(map[i][j] == 1 && map[i][j-1] == 0)	cnt++;
				if(map[i][j] == 0 && map[i][j-1] == 1)	cnt++;
				if(map[j][i] == 1 && map[j-1][i] == 0)	cnt++;
				if(map[j][i] == 0 && map[j-1][i] == 1)	cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
