package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws IOException {
		int[][] map = new int[100][100];
		int sum = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int leftX = Integer.parseInt(st.nextToken());
			int leftY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());
			
			
			for (int j = leftY; j < rightY ; j++) {
				for (int j2 = leftX; j2 < rightX; j2++) {
					if(map[j][j2] == 1)	continue;
					map[j][j2] = 1;
					sum++;
				}
			}
		
		}
		
		System.out.println(sum);
		
		
		
	}

}
