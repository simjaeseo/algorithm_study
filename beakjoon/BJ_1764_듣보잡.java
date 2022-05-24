package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> hashSet = new HashSet<>();
		
		
		for (int i = 0; i < N; i++) {
			hashSet.add(br.readLine());
		}
		
		int preCnt = hashSet.size();
		List<String> l = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			hashSet.add(s);
			
			int nowCnt = hashSet.size();
			
			if(nowCnt == preCnt) {
				l.add(s);
			}else {
				preCnt = nowCnt;
			}
		}
		
		
		Collections.sort(l);
		
		System.out.println(l.size());
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		
	}

}
