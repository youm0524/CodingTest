package 자바알고리즘인터뷰.연결리스트;

public class leet_21 {

    // 연결리스트 노드 정의
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 반복문을 사용한 병합 함수
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answer = new ListNode();  // dummy 노드
        ListNode current = answer;

        // 두 리스트 모두 끝날 때까지 반복
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 남아있는 노드를 붙임
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return answer.next;  // dummy 다음부터가 실제 병합된 리스트
    }

    // 리스트 출력 함수
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // 테스트 코드 (main 함수)
    public static void main(String[] args) {
        // list1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // list2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // 병합 실행
        ListNode merged = mergeTwoLists(list1, list2);

        // 결과 출력
        System.out.println("✅ 병합된 연결 리스트:");
        printList(merged);
    }
}
