package 자바알고리즘인터뷰.연결리스트;

import java.util.Stack;

public class leet_234 {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;

        // 모든 노드 값을 스택에 저장
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        // 다시 처음부터 값 비교
        current = head;
        while (!stack.isEmpty()) {
            if (current.val != stack.pop()) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    // 테스트 코드
    public static void main(String[] args) {
        // 예: [1 -> 2 -> 2 -> 1]
        ListNode node4 = new ListNode(1);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        boolean result = isPalindrome(node1);
        System.out.println("Is palindrome? " + result); // 출력: true
    }
}

