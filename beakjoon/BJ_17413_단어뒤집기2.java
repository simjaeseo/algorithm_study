package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		boolean tagCheck = false;
		Stack<Character> reverse = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length; i++) {
			
			if(str[i] == '<') {
				// 태그와 태그 사이에 뒤집기 위한 글자가 스택에 들어가 있을 수 있으니
				while(!reverse.isEmpty()) {
					sb.append(reverse.pop());
				}
				tagCheck = true;
				sb.append("<");
				continue;
			}
			else if(str[i] == '>')	{
				tagCheck = false;
				sb.append(">");
				continue;
			}
			
			if(!tagCheck) {
				// 태그 안이 아니기 때문에 공백이 나오면 다음 단어가 나오기 전이라는 의미
				if(str[i] == ' ') {
					while(!reverse.isEmpty()) {
						sb.append(reverse.pop());
					}
					sb.append(" ");
				}else {
					// 단어의 알파벳을 하나씩 스택에 추가
					reverse.add(str[i]);
				}
			}else {
				// 태그 안의 문자들을 출력하기위해 stringbuilder에 추가
				sb.append(str[i]);
			}
			
		}
		
		// 뒤집어야할 문자가 스택에 남아있을 수 있으니 마지막으로 한번 더 체크
		while(!reverse.isEmpty()) {
			sb.append(reverse.pop());
		}
		
		System.out.print(sb);
	}

}
