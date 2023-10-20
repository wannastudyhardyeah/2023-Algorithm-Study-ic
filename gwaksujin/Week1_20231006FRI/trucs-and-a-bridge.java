import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 트럭이 올라갈 일차선 다리 큐를 생성함
        Queue<Integer> queue = new LinkedList<>();

        int sum = 0; // 트럭의 무게의 합
        int time = 0; // 트럭 이동 시간

        /*
        * 총 3가지 경우를 고려해야 함
        * 1. 큐가 비어있는 경우 (일차선 도로에 진입한 트럭이 없음)
        * 2. 큐가 가득차지 않은 경우 (트럭 무게의 합이 weight을 넘기지 않음)
        * 3. 큐가 가득찬 경우
        *   1) 일차선 도로에 있는 트럭 무게의 합 + 새로 올라올 트럭의 무게 <= 다리가 견딜 수 있는 무게
        *      : 큐가 비어있는 경우와 동일하게 구현
        *   2) 일차선 도로에 있는 트럭 무게의 합 + 새로 올라올 트럭의 무게 > 다리가 견딜 수 있는 무게
        *      : 큐에 0 값을 넣어줌
        * */

        for(int i=0; i<truck_weights.length; i++){
            int truck = truck_weights[i];

            while(true){
                if(queue.isEmpty()){ // 1. 큐가 비어있는 경우
                    queue.add(truck);
                    sum += truck;
                    time++; // 트럭이 다리에 올라간 순간부터 시간 + 1
                    break;
                } else if(queue.size() == bridge_length){ // 3. 큐가 가득 찬 경우
                    sum -= queue.poll(); // 제일 앞에 있는 트럭이 나가면서 트럭 무게 합에서 빠짐
                } else{
                    if(sum + truck <= weight){ // 3. 큐가 가득차지 않은 경우
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length; // 총 트럭 이동 시간 + 마지막 트럭이 건너는데 걸리는 시간(다리의 길이)
    }
}