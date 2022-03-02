package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2947_나무조각 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[5];
		
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 4; i++) {
				if(arr[i]>arr[i+1]) {
					int tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					for (int j = 0; j < 5; j++) {
						System.out.print(arr[j] + " ");
					}
					System.out.println();
				}
			}
		}

		
	}

}
