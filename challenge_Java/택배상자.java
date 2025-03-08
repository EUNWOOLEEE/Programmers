class Solution {
    public int solution(int[] order) {
        int len = order.length;
        int[] stack = new int[len];
        
        int queueHead = 1, stackTop = 0;
        int idx = 0;
        
        while (idx < len) {
            if (queueHead == order[idx]) {
                idx++;
                queueHead++;
            }
            else if (stack[stackTop] == order[idx]) {
                idx++;
                stackTop--;
            }
            else if (queueHead <= len)
                stack[++stackTop] = queueHead++;
            else
                break;
        }
        
        return idx;
    }
}

/* 스택과 큐 자료구조 활용한 풀이 */

// import java.util.*;

// class Solution {
//     public int solution(int[] order) {
//         Queue<Integer> queue = new LinkedList<>();
//         Stack<Integer> stack = new Stack<>();
        
//         for (int i = 1; i <= order.length; i++)
//             queue.add(i);
        
//         int idx = 0;
//         while (idx < order.length) {
//             if (queue.size() > 0 && queue.peek() == order[idx]) {
//                 idx++;
//                 queue.poll();
//             }
//             else if (stack.size() > 0 && stack.peek() == order[idx]) {
//                 idx++;
//                 stack.pop();
//             }
//             else if (queue.size() > 0)
//                 stack.add(queue.poll());
//             else
//                 break;
//         }
        
//         return idx;
//     }
// }