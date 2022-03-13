package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2941_크로아티아알파벳 {
	static int i = 0;
	static int cnt = 0;
	static char[] str = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().toCharArray();

		for (i = 0; i < str.length; i++) {
			checkAlphabet(str[i], i);
		}
		System.out.println(cnt);
	}

	static void checkAlphabet(char alphabet, int idx) {
		if (idx != str.length - 1 && alphabet == 'c' && (str[idx + 1] == '=' || str[idx + 1] == '-')) {
			i += 1;
			cnt += 1;
		} else if (idx != str.length - 1 && alphabet == 'd' && str[idx + 1] == '-') {
			i += 1;
			cnt += 1;
		} else if (idx != str.length - 1 && alphabet == 'l' && str[idx + 1] == 'j') {
			i += 1;
			cnt += 1;
		} else if (idx != str.length - 1 && alphabet == 'n' && str[idx + 1] == 'j') {
			i += 1;
			cnt += 1;
		} else if (idx != str.length - 1 && alphabet == 's' && str[idx + 1] == '=') {
			i += 1;
			cnt += 1;
		} else if (idx != str.length - 1 && alphabet == 'z' && str[idx + 1] == '=') {
			i += 1;
			cnt += 1;
		} else if (idx != str.length - 1 && idx != str.length - 2 && alphabet == 'd' && str[idx + 1] == 'z'
				&& str[idx + 2] == '=') {
			i += 2;
			cnt += 1;
		} else {
			cnt += 1;
		}
	}

}
