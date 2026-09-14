class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode tail = head;

       
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        
        k = k % len;

        
        tail.next = head;

        
        ListNode temp = head;

        for (int i = 1; i < len - k; i++) {
            temp = temp.next;
        }

        
        ListNode newHead = temp.next;

        
        temp.next = null;

        return newHead;
    }
}