package 자바알고리즘인터뷰.연결리스트;
public class leet_24 {

    /** 연결 리스트 노드 정의 */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /** 두 노드를 쌍으로 스왑하는 함수 (정석 반복문 커서 방식) */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);   // dummy: head 위치 쉽게 조작하기 위함
        dummy.next = head;

        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            // 스왑할 두 노드
            ListNode a = cur.next;
            ListNode b = cur.next.next;

            // ⛓️ 포인터 스왑
            a.next = b.next;    // a가 b 다음을 가리킴
            b.next = a;         // b가 a를 가리킴
            cur.next = b;       // cur이 b를 가리키게 연결

            // 다음 쌍으로 이동
            cur = a;
        }

        return dummy.next;
    }

    /** 리스트 출력 함수 */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    /** 테스트용 main 함수 */
    public static void main(String[] args) {
        // 테스트 케이스: 1 → 2 → 3 → 4 → 5
        ListNode test = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        System.out.println("👉 원본 리스트:");
        printList(test);

        ListNode swapped = swapPairs(test);

        System.out.println("✅ 스왑 후 리스트:");
        printList(swapped);
    }
}

