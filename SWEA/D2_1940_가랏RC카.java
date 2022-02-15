package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1940_가랏RC카 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {

			int N = Integer.parseInt(br.readLine());
			int speed = 0;
			int distance =0;
			for (int j = 1; j <= N; j++) {

				StringTokenizer st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int Acceleration = 0;
				if(cmd != 0)	Acceleration = Integer.parseInt(st.nextToken());
				

				switch (cmd) {
				case 0:
					distance += speed;
					break;
				case 1:
					speed += Acceleration;
					distance += speed;
					break;
				case 2:
					if(speed - Acceleration >= 0)	speed -= Acceleration;
					else speed = 0;
					distance += speed;
					break;
				}
			}

			System.out.println("#" + i + " " + distance);

		}

	}

}
