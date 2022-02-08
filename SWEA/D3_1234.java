package webexWS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D3_1234 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 10; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int tc = Integer.parseInt(st.nextToken());
			String[] pw = st.nextToken().split("");
			
			LinkedList<Integer> list = new LinkedList<>();
			
			for (int j = 0; j < pw.length; j++) {
				list.addLast(Integer.parseInt(pw[j]));
			}
			
			int cnt = 1;
			while(list.size()!= cnt) {
				cnt = 1;
				for (int j = 0; j < list.size()-1; j++) {
					if(list.get(j) == list.get(j+1)){
						list.remove(j);
						list.remove(j);
						break;
					}else {
						cnt++;
					}
				}
			}
			
			System.out.print("#" + i + " ");
			for (int j : list) {
				System.out.print(j);
			}
			System.out.println();
			
			
		}
		
		
		
		
		
	}

}
