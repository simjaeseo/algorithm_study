package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14696_딱지놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int[] aArr = new int[5];
			int[] bArr = new int[5];
			st = new StringTokenizer(br.readLine());
			int aNum = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < aNum; j++) {
				aArr[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int bNum = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < bNum; j++) {
				bArr[Integer.parseInt(st.nextToken())]++;
			}
			
			char win = 'D';
			// a카드, b카드 비교
			if(aArr[4] > bArr[4])	win = 'A';
			else if(aArr[4] < bArr[4]) win = 'B';
			else {
				// 별이 같을때
				if(aArr[3] > bArr[3])	win = 'A';
				else if(aArr[3] < bArr[3]) win = 'B';
				else {
					// 동그라미가 같을때
					if(aArr[2] > bArr[2])	win = 'A';
					else if(aArr[2] < bArr[2]) win = 'B';
					else {
						// 네모가 같을때
						if(aArr[1] > bArr[1])	win = 'A';
						else if(aArr[1] < bArr[1]) win = 'B';
					}
				}
			}
			System.out.println(win);
		}
		
	}

}
