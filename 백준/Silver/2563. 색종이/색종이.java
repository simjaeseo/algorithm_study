import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] white = new int[100][100];
		
		int x = 0;
		int y = 0;
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for (int j = y; j < y + 10 ; j++) {
				for (int j2 = x; j2 < x+10 ; j2++) {
					if(white[j][j2] == 1)	continue;
					white[j][j2] = 1;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
