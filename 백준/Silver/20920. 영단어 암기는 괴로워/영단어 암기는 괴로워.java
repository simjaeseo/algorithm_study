import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    private static int n, k;
    private static ArrayList<Integer> l = new ArrayList<>();
    private static Map<String, Integer> m = new HashMap<>();

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            if (s.length() < k) continue;

            m.put(s, m.getOrDefault(s, 1) + 1);
        }

        Voca[] vocas = new Voca[m.size()];

        int index = 0;

        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            vocas[index++] = new Voca(entry.getKey(), entry.getValue());
        }
        Arrays.sort(vocas);

        for(Voca v : vocas){
            sb.append(v.voca).append('\n');
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);

    }

    public static class Voca implements Comparable<Voca> {
        String voca;
        int count;

        public Voca(String voca, int count) {
            this.voca = voca;
            this.count = count;
        }

        @Override
        public int compareTo(Voca o1) {
            if (this.count != o1.count) {
                return o1.count - this.count;
            } else if (this.voca.length() != o1.voca.length()) {
                return o1.voca.length() - this.voca.length();
            } else {
                for (int i = 0; i < this.voca.length(); i++) {
                    if (this.voca.charAt(i) == o1.voca.charAt(i)) continue;
                    return this.voca.charAt(i) - o1.voca.charAt(i);
                }
            }
            return 0;
        }
    }


}