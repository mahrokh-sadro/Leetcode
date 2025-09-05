//92. Reverse Linked List II

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        var dummy=new ListNode(-1);
        var dummyHead=dummy;
        dummy.next=head;

        ListNode left_head=dummy;
        ListNode right_head=dummy;
        ListNode pre_left=null;
        for(int i=0;i<left;i++){
            pre_left=left_head;
            left_head=left_head.next;
        }
        right_head=left_head;

        for(int i=left;i<right+1;i++){
            right_head=right_head.next;
        }

        var cur=left_head;
        ListNode pre=null;
        ListNode next=null;
        while(cur!=right_head){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;  
        }

        pre_left.next.next=cur;
        pre_left.next=pre;

        return dummyHead.next;
    }
}