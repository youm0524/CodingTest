import java.util.ArrayList;
import java.util.Stack;

public class leetcode_232 {

    // LeetCode에서 요구하는 큐 클래스
    static class MyQueue {
        private Stack<Integer> stack = new Stack<>();

        public MyQueue() {}

        // push: 기존 요소 모두 잠깐 빼두고 x를 넣은 뒤, 역순으로 되돌려서 FIFO 유지
        public void push(int x) {
            ArrayList<Integer> before = new ArrayList<>();
            while (!stack.isEmpty()) {
                before.add(stack.pop());
            }
            stack.push(x);
            for (int i = before.size() - 1; i >= 0; i--) {
                stack.push(before.get(i));
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }

    // 로컬 테스트용 main (제출 시엔 필요 없음)
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.peek()); // 1
        System.out.println(q.pop());  // 1
        System.out.println(q.pop());  // 2
        System.out.println(q.empty()); // false
        q.push(4);
        System.out.println(q.pop());  // 3
        System.out.println(q.pop());  // 4
        System.out.println(q.empty()); // true
    }
}
