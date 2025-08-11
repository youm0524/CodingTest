package 자바알고리즘인터뷰.스택;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_225 {

    static class MyStack {
        private final Queue<Integer> q = new LinkedList<>();

        public MyStack() {}

        public void push(int x) {
            q.add(x);
            int size = q.size();
            for (int i = 0; i < size - 1; i++) {
                q.add(q.remove());
            }
        }

        public int pop() {
            return q.remove();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

    // 로컬 테스트용 main
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());   // 2
        System.out.println(obj.pop());   // 2
        System.out.println(obj.top());   // 1
        System.out.println(obj.empty()); // false
    }
}

