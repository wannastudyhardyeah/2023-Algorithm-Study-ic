import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Ex42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            // 개별 가격마다 카운트를 진행해서 배열에 넣어줘야함.
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                // 기본적으로는 일단 더하고 본다.
                count++;
                // 이전가격이 크다면 주식이 하락장의 의미
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
