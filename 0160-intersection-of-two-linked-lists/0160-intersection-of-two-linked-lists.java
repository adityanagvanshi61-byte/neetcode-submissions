
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1=0;
        int l2=0;
        ListNode temp1=headA;
        while(temp1 != null){
            temp1=temp1.next;
            l1++;

        }
        ListNode temp2=headB;
        while(temp2 !=null){
            temp2=temp2.next;
            l2++;
        }
        temp1=headA;
        temp2=headB;
        if(l1>l2){
            for(int i=0;i<l1-l2;i++){
                temp1=temp1.next;
            }
        }
        if(l2>l1){
            for(int i=0;i<l2-l1;i++){
                temp2=temp2.next;
            }
        }
        while(temp1 != temp2){
            temp1=temp1.next;
            temp2=temp2.next;
        }

return temp1;
    }
}