package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_진기의최고급붕어빵 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[]  arrivalSec = new int[N]; 
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arrivalSec[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arrivalSec);
			int guestIdx = 0;
			int breadNum = 0;
			boolean flag = true;
			for (int j = 0; j <= arrivalSec[N-1]; j++) {
				if(j%M == 0) {
					if(j!=0) breadNum += K;
				}
				if(arrivalSec[guestIdx] == j) {
					// 배열에 해당 초에 오는 손님이 더 오는지 체크 후 카운트해서 변수에 담아 놓은뒤에
					// 그만큼 bread 빼고, guestIdx도 그만큼 더해주기
					int cnt = 0;
					for (int l = guestIdx; l < N; l++) {
						if(arrivalSec[l] == j) cnt++;
					}
					if(breadNum-cnt >=0) {
						breadNum -= cnt;
						guestIdx +=cnt;
					}else {
						flag = false;
						break;
					}
				}
			}
			if(flag)	System.out.println("#" + i + " " + "Possible");
			else	System.out.println("#" + i + " " + "Impossible");
		}
	}

}
