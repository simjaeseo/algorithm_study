import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    static Lecture[] lectures;
    static PriorityQueue<Lecture> classRoom;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        process();
        print();
    }

    private static void print() {
        System.out.println(classRoom.size());
    }

    private static void process() {

        for (Lecture l : lectures) {

            if (classRoom.isEmpty()) {
                classRoom.add(l);
                continue;
            }

            Lecture earlyEndLecture = classRoom.peek();

            // 강의실을 새로 배정해야하는 경우, (현재 진행하는 강의 중 이어서 할 수 있는 강의실이 없는 경우)
            if (earlyEndLecture.end <= l.start) {
                classRoom.poll();
            }

            classRoom.add(l);
        }
    }

    public static void init() throws IOException {




        classRoom = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o1.end - o2.end;
            }
        });

        N = Integer.parseInt(br.readLine());
        lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                }

                return o1.end - o2.end;
            }
        });
    }


    public static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}