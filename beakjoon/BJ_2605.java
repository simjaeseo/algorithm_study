package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		LinkedList<Integer> line = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			line.add(number, i+1);
		}
		
		for (int i = N-1; i >= 0; i--) {
			System.out.print(line.get(i) + " ");
		}
		
	}

}
