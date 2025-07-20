package 자바알고리즘인터뷰.연결리스트;

public class leet_206 {

    // ListNode 클래스 정의 (문제에서 주어진 구조 사용)
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 연결 리스트 뒤집기 (반복문 방식)
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode now = head;

        while (now != null) {
            // 다음 노드 미리 저장
            ListNode next = now.next;

            // 방향 뒤집기
            now.next = prev;

            // prev와 now 포인터 이동
            prev = now;
            now = next;
        }

        // 마지막에 prev가 새 head가 됨
        return prev;
    }

    // 연결 리스트 출력 함수
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // 테스트용 main 메서드
    public static void main(String[] args) {
        // 원래 연결 리스트: 1 -> 2 -> 3 -> 4 -> 5
        ListNode original =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)))));

        System.out.println("👉 원본 리스트:");
        printList(original);

        // 연결 리스트 뒤집기
        ListNode reversed = reverseList(original);

        System.out.println("✅ 뒤집힌 리스트:");
        printList(reversed);
    }
}

