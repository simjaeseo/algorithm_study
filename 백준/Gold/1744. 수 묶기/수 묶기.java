import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static List<Integer> naturalNumbers = new ArrayList<>();
    static List<Integer> negativeNumbers = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();

        solve();
    }


    private static void solve() {

        Collections.sort(naturalNumbers, Collections.reverseOrder());
        Collections.sort(negativeNumbers);

        int sum = 0;

        for (int i = 0; i < naturalNumbers.size()-1; i++) {
            int firstNumber = naturalNumbers.get(i);
            int secondNumber = naturalNumbers.get(i+1);

            if(firstNumber * secondNumber > firstNumber + secondNumber) sum += firstNumber * secondNumber;
            else sum += firstNumber + secondNumber;
            i++;
        }

        if(naturalNumbers.size() % 2 != 0) sum += naturalNumbers.get(naturalNumbers.size()-1);


        for (int i = 0; i < negativeNumbers.size()-1; i++) {
            int firstNumber = negativeNumbers.get(i);
            int secondNumber = negativeNumbers.get(i+1);

            if(firstNumber * secondNumber > firstNumber + secondNumber) sum += firstNumber * secondNumber;
            else sum += firstNumber + secondNumber;
            i++;
        }

        if(negativeNumbers.size() % 2 != 0) sum += negativeNumbers.get(negativeNumbers.size()-1);

        System.out.println(sum);


    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            if(number > 0 ) naturalNumbers.add(number);
            else negativeNumbers.add(number);
        }
    }

}
