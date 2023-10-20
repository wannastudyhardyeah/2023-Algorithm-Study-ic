import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        final Queue<Integer> q = new LinkedList<>();

        int answer = 0;

        // 빈 공간을 다리 길이만큼 생성
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }

        int idx = 0;
        int sum = 0;

        while (idx < truck_weights.length) {
            answer++;
            sum -= q.poll();
            if (sum + truck_weights[idx] <= weight) {
                q.offer(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else {
                // 총 무게보다 큰경우는 왼쪽으로 밀어서 다리를 지나가게 만들어야 한다.
                q.offer(0);
            }
        }

        // 맨 마지막의 트럭도 지나가게 해주어야되기 때문에 0으로 채워줄바엔 다리 길이만큼 더해준다.
        return bridge_length + answer;
    }
}
