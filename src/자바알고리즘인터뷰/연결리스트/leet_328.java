package 자바알고리즘인터뷰.연결리스트;

// leet_328.java

public class leet_328 {

    // ✅ Definition for singly-linked list
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        // for printing
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode curr = this;
            while (curr != null) {
                sb.append(curr.val);
                if (curr.next != null) sb.append(" → ");
                curr = curr.next;
            }
            return sb.toString();
        }
    }

    public static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return null;

            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                odd = odd.next;

                even.next = even.next.next;
                even = even.next;
            }

            odd.next = evenHead;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        System.out.println("Input: " + input);

        Solution sol = new Solution();
        ListNode result = sol.oddEvenList(input);

        System.out.println("Output: " + result);
        // Expected: 1 → 3 → 5 → 2 → 4
    }
}
