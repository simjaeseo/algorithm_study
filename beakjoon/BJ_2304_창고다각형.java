package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2304_창고다각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		Pillar[] pillar = new Pillar[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			pillar[i] = new Pillar(x,height);
		}
		
		Arrays.sort(pillar);
		
		int sum = 0;
		int previousX = pillar[0].x;
		int previousHeight = pillar[0].height;
		int maxIdx = 0;
		
		for (int i = 1; i < N; i++) {
			if(previousHeight <= pillar[i].height ) {
				sum += (pillar[i].x - previousX) * previousHeight;
				previousX = pillar[i].x;
				previousHeight = pillar[i].height;
				maxIdx = i;
			}
		}
		
		sum += previousHeight;
		
		previousX = pillar[N-1].x;
		previousHeight = pillar[N-1].height;
		for (int i = N-2; i >=maxIdx ; i--) {
			if(previousHeight < pillar[i].height ) {
//				System.out.println(((previousX+1) - (pillar[i].x+1)) * previousHeight);
				sum += ((previousX+1) - (pillar[i].x+1)) * previousHeight;
				previousHeight = pillar[i].height;
				previousX = pillar[i].x;
			}
		}
		
		if(N == 1)	sum = previousHeight;
		System.out.println(sum);
		
	}
	
	
	static class Pillar implements Comparable<Pillar>{
		int x, height;

		public Pillar(int x, int height) {
			super();
			this.x = x;
			this.height = height;
		}


		@Override
		public int compareTo(Pillar o) {
			// TODO Auto-generated method stub
			return this.x-o.x;
		}


		@Override
		public String toString() {
			return "Pillar [x=" + x + ", height=" + height + "]";
		}
		
		
		
		
	}
	
}
