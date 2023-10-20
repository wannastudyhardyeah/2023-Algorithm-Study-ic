import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder answer = new StringBuilder();

        int total = Integer.parseInt(br.readLine());
        int[] arr = new int[total];

        for (int i = 0; i < total; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i : arr) {
            if (q.isEmpty() && i == 0) {
                answer.append(i).append("\n");
            } else if (!q.isEmpty() && i == 0) {
                answer.append(q.poll()).append("\n");
            } else {
                q.offer(i);
            }
        }

        System.out.println(answer);
    }
}
