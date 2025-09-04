//143. Reorder List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return ;
        }
        //find the middle
        //reverse secod part
        //if f!=null slow.next
        var fast=head;
        var slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

       

        var slowHead=reverse(slow.next);
        fast=head;
        slow.next=null;
        
        var dummy=new ListNode(-1);
        var dummyHead=dummy; 
        while(fast!=null && slowHead!=null){
             dummy.next=fast;
             dummy=dummy.next;
             fast=fast.next;
             dummy.next=slowHead;
             slowHead=slowHead.next;
             dummy=dummy.next;   
        }

        if(fast!=null){
            dummy.next=fast;
        }

        // return dummyHead.next;

    }

    private ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        var cur=head;
        ListNode pre=null;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;

    }
}
