import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 스택을 활용하는 것보다 이중 for문으로 쉽게 구현 가능
        int[] answer = new int[prices.length];

        // 현재를 기준으로 이후 값들이 현재 값보다 크면 시간 + 1
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                // 현재 값보다 작은 값을 만나면 break
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}