
import java.util.Scanner;

public class Main {

	static int cnt = 0;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner	in = new Scanner(System.in);
		
		int N = in.nextInt();
		hanoi(N,1,2,3);
		
		System.out.println(cnt);

		System.out.println(sb);
	}
	
	public static void hanoi(int N, int from, int temp, int to) {
		if(N==0) {
//			System.out.println(cnt);
			return;
		}
		
		// n-1 덩어리 먼저 처음 옮기기
		hanoi(N-1,from,to,temp);
		
		sb.append(from + " " + to + "\n");
		
		
		hanoi(N-1,temp,from,to);
		
		cnt++;
		
		
	}

}
