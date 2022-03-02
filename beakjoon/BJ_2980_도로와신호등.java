package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2980_도로와신호등 {
	static int time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Node[] road = new Node[L];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			road[D] = new Node(R,G);
		}
		
		for (int i = 0; i < L; i++) {
			if(road[i] != null) {
				wait(time, road[i]);
			}
			time++;
		}
		System.out.println(time);
		
	}
	
	static void wait(int timeTmp, Node light) {
		
		while(true) {
			if(timeTmp-light.redTime == 0)	break;
			if(timeTmp-light.redTime < 0)	{
				time+= Math.abs(timeTmp-light.redTime);
				break;
			}
			timeTmp-= light.redTime;
			
//			if(timeTmp < light.greenTime) break;
			if(timeTmp-light.greenTime < 0)	break;
//			if(timeTmp-light.greenTime == 0)break;
			timeTmp -= light.greenTime;
			
		}
		
		
	}
	
	static class Node{
		int redTime = 0;
		int greenTime = 0;
		
		public Node(int redTime, int greenTime) {
			super();
			this.redTime = redTime;
			this.greenTime = greenTime;
		}
		
	}

}
