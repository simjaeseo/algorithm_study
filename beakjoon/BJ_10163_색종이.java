package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10163_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[1001][1001];
		int maxX = 0;
		int maxY = 0;
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			maxX = Math.max(startX+width, maxX);
			maxY = Math.max(startY+height, maxY);
		
			for (int j = startY; j < startY+height; j++) {
				for (int j2 = startX; j2 < startX+width; j2++) {
					map[j][j2] = i;
				}
			}
		}
//		for (int j = 0; j < maxY; j++) {
//			for (int j2 = 0; j2 < maxX; j2++) {
//				System.out.print(map[j][j2]);
//			}
//			System.out.println();
//		}
		
		
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 0; j < maxY; j++) {
				for (int j2 = 0; j2 < maxX; j2++) {
					if(map[j][j2] == i) sum++;
				}
			}
			System.out.println(sum);
		}
		
		
		
	}

}
