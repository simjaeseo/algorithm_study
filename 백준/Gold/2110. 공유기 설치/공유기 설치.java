import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberOfHouse = Integer.parseInt(st.nextToken());
        int numberOfShareMachine = Integer.parseInt(st.nextToken());

        house = new int[numberOfHouse];

        for (int i = 0; i < numberOfHouse; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        // 탐색하는 것 = 공유기 설치 수
        int start = 1;
        int end = house[numberOfHouse-1] - house[0];
        int max = 0;

        while(start <= end){
            int mid = (start + end) / 2;

            int canInstallNumber = install(mid);

            if(canInstallNumber >= numberOfShareMachine){
                max = mid;
                start = mid +1;
            }else if(canInstallNumber < numberOfShareMachine){
                end = mid -1;
            }
        }
        System.out.println(max);
        // 1 2 4 8 9
    }

    private static int install(int distance) {
        int count = 1;

        int lastInstallHouse = house[0];

        for (int i = 1; i < house.length; i++) {
            int nextInstallHouse = house[i];

            if(nextInstallHouse - lastInstallHouse >= distance){
                count++;
                lastInstallHouse = nextInstallHouse;
            }
        }
        return count;
    }
}