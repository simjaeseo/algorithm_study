package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_10431_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int P = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int tc = Integer.parseInt(st.nextToken());
			
			List<Child> line = new LinkedList<>();
			
			Child childTmp = null;
			
			for (int j = 0; j < 20; j++) {
				int height = Integer.parseInt(st.nextToken());
				
				childTmp = new Child(height, 0);
				
				if(line.isEmpty()) {
					line.add(childTmp);
				}else {
					boolean flag = true;
					int startIdx = 0;
					for (int k = 0; k < line.size(); k++) {
						if(childTmp.height < line.get(k).height) {
							line.add(k, childTmp);
							startIdx = k+1;
							flag = false;
							break;
						}
					}
					if(flag) {
						line.add(childTmp);
					}else {
						for (int k = startIdx; k < line.size(); k++) {
							line.get(k).cnt++;
						}
					}
				}
			}
			
			int cnt = 0;
			for (int j = 0; j < line.size(); j++) {
				cnt += line.get(j).cnt;
			}
			
			System.out.println(tc + " " + cnt);
			
		}
		
	}
	
	static class Child{
		int height = 0;
		int cnt = 0;
		
		public Child(int height, int cnt) {
			super();
			this.height = height;
			this.cnt = cnt;
		}
	}

}
