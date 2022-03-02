package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2527_직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[] x = new int[2];
		int[] y = new int[2];
		int[] p = new int[2];
		int[] q = new int[2];
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < 4; i++) {
			char result = 'a';
			st = new StringTokenizer(br.readLine());
			
			x[0] = Integer.parseInt(st.nextToken());
			y[0] = Integer.parseInt(st.nextToken());
			p[0] = Integer.parseInt(st.nextToken());
			q[0] = Integer.parseInt(st.nextToken());
			
			x[1] = Integer.parseInt(st.nextToken());
			y[1] = Integer.parseInt(st.nextToken());
			p[1] = Integer.parseInt(st.nextToken());
			q[1] = Integer.parseInt(st.nextToken());
			
			
			
		}
		
		
		
		
		
		
	}

}
