package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


// https://nato-blog.tistory.com/11 블로그 참고

public class BJ_2564_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int storeCnt = Integer.parseInt(br.readLine());
		int sum = 0;
		int dongPos = 0;
		int totalLength = (width+height)*2;
		
		int[] rectangle = new int[(width+height)*2];
		
		
		
		for (int i = 0; i <= storeCnt; i++) {
			st = new StringTokenizer(br.readLine());
			
			int direction = Integer.parseInt(st.nextToken());
			int tmpPos = 0;
			
			switch (direction) {
			case 1:
				//북
				tmpPos = Integer.parseInt(st.nextToken());
				break;
			case 4:
				//동
				tmpPos = width + Integer.parseInt(st.nextToken());
				break;
			case 2:
				tmpPos = 2*width + height - Integer.parseInt(st.nextToken());
				break;
			case 3:
				tmpPos = 2*width + 2*height - Integer.parseInt(st.nextToken());
				break;
			}
			if(i == storeCnt)	dongPos = tmpPos;
			rectangle[tmpPos] = 1;
		}
		
		for (int i = 0; i < totalLength; i++) {
			
			if(dongPos + i == totalLength)	dongPos = -i;
			if(rectangle[dongPos+i] == 1)	sum += Math.min(i, totalLength - i);
			
		}
		
		System.out.println(sum);
	
	}
	
	
	

}
