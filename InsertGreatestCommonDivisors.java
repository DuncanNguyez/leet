public class InsertGreatestCommonDivisors {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode result = head;
        ListNode current = head;
        head = head.next;
        while (head != null) {
            if (current.val < head.val)
                current.next = new ListNode(greatestCommonDivisor(current.val, head.val), head);
            else current.next = new ListNode(greatestCommonDivisor(head.val, current.val), head);

            current = head;
            head = head.next;
        }
        return result;
    }

    // n2 > n1
    int greatestCommonDivisor(int n1, int n2) {

        if (n2 == 0) {
            return n1;
        } else {
            return greatestCommonDivisor(n2, n1 % n2);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
