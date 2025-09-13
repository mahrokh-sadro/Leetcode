//61. Rotate List

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }

        int size=size(head);
        if(size==k || k%size==0){
            return head;
        }

        k%=size;

        var dummy=new ListNode(-1);
        dummy.next=head;
        var dummyHead=dummy;

        var slow=dummy;
        var fast=dummy;

        for(int i=0;i<k;i++){
            fast=fast.next;
        }
        ListNode newHead=null;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        newHead=slow.next;

        fast.next=head;
        slow.next=null;

        return newHead;

    }

    private int size(ListNode head){
        if(head==null){
            return 0;
        }

        var cur=head;
        int count=0;
        while(cur!=null){
            cur=cur.next;
            count++;
        }
        return count;
    }


}