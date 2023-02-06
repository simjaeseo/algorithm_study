import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
    
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
        
		for(int i = 0; i < N; i++){
			array[i] = Integer.parseInt(br.readLine());
		}
        
		Arrays.sort(array);
        
		StringBuilder sb = new StringBuilder();
        
		for(int i = 0; i < N; i++){
			sb.append(array[i]).append('\n');
		}
 
		System.out.println(sb);
	}
}